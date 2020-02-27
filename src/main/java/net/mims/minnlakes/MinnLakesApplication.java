package net.mims.minnlakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.mims.minnlakes.domain.FishSpecies;

@SpringBootApplication
public class MinnLakesApplication {

	private static final Logger log = LoggerFactory.getLogger(MinnLakesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MinnLakesApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@SuppressWarnings({ "unchecked", "null" })
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {

			// String baseUrl =
			// "https://maps2.dnr.state.mn.us/cgi-bin/lakefinder_json.cgi?name=Clear&county=58";
			String baseUrl = "https://maps2.dnr.state.mn.us/cgi-bin/lakefinder_json.cgi?county=58";
			String output = null;
			final ObjectMapper mapper = new ObjectMapper();

			try {

				URL url = new URL(baseUrl);

				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				while ((output = br.readLine()) != null) {
					System.out.println(output);

					System.out.println(output);

					JsonNode rootArray = mapper.readTree(output);

					JsonNode lakeNode = rootArray.path("results");

					for (JsonNode lake : lakeNode) {

						JsonNode nameNode = lake.findPath("name");

						String lakeName = nameNode.asText();

						System.out.println("LakeName : " + lakeName);

						JsonNode countyNode = lake.findPath("county");

						String countyName = countyNode.asText();

						System.out.println("CountyName : " + countyName);

						JsonNode acresNode = lake.findPath("area");

						String acres = acresNode.asText();

						System.out.println("Acres : " + acres);

						JsonNode pointNode = lake.findPath("point");
						System.out.println("point : " + pointNode.asText());

						JsonNode geoCenterNode = pointNode.findPath("epsg:4326");
						System.out.println("epsg:4326 is array " + geoCenterNode.toString());

						int counter = 0;
						Double[] coords = new Double[2];
						for (JsonNode coord : geoCenterNode) {
							coords[counter] = coord.asDouble();

							counter++;
							System.out.println("coord : " + coord.asDouble());

						}

						System.out.println("latlong: " + coords);

						JsonNode speciesNode = lake.findPath("fishSpecies");

						for (JsonNode name : speciesNode) {
							String fish = name.asText();

							System.out.println("type : " + fish);

						}

					}

				}

				conn.disconnect();

			} catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			}

		};
	}
}
