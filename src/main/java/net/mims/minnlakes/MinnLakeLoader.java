package net.mims.minnlakes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.mims.minnlakes.data.WriteMinnDataToDatabase;
import net.mims.minnlakes.domain.FishSpecies;
import net.mims.minnlakes.domain.Waterbody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class MinnLakeLoader {

	// String baseUrl =
	// "https://maps2.dnr.state.mn.us/cgi-bin/lakefinder_json.cgi?name=Clear&county=58";

	final String URL_OF_MINN_DNR_SERVICE = "https://maps2.dnr.state.mn.us/cgi-bin/lakefinder_json.cgi?county={countyID}";
	final int NUMBER_OF_MINN_COUNTIES = 87; // 87
	final String STATE_ABBREVIATION = "MN";
	final String STATE_NAME = "MINNESOTA";
	final int MAX_LAKENAME = 72;

	private ArrayList<Waterbody> waterbodies = new ArrayList<Waterbody>();
	@Autowired
	WebClient webClient;

	public MinnLakeLoader(WebClient webClient) {
		this.webClient = webClient;

	}

	public void retrieveDataAndSaveToDatabase() {



		this.waterbodies = getLakeDataFromRestService();
		WriteMinnDataToExcel writeMinnData = new WriteMinnDataToExcel(this.waterbodies);
		WriteMinnDataToDatabase writeMinnDataToDatabase = new WriteMinnDataToDatabase(this.waterbodies);

	}

	public ArrayList<Waterbody> getLakeDataFromRestService() {



		for (int countyNumber = 1; countyNumber <= NUMBER_OF_MINN_COUNTIES; countyNumber++) {

			String output = null;
			final ObjectMapper mapper = new ObjectMapper();

			try {
				String countyID = String.valueOf(countyNumber);
				Mono<String> result = webClient.get().uri(URL_OF_MINN_DNR_SERVICE, countyID)
						.retrieve()
						.bodyToMono(String.class);
				String input = result.block();


					System.out.println(input);

					JsonNode rootArray = mapper.readTree(input);

					JsonNode lakeNode = rootArray.path("results");

					for (JsonNode lake : lakeNode) {

						JsonNode nameNode = lake.findPath("name");

						String lakeName = nameNode.asText();
						
						if(lakeName.length() > MAX_LAKENAME ){
						    lakeName = lakeName.substring(0, MAX_LAKENAME);
						}

						JsonNode countyNode = lake.findPath("county");

						String countyName = countyNode.asText();

						JsonNode acresNode = lake.findPath("area");

						Double acres = acresNode.asDouble();

						JsonNode pointNode = lake.findPath("point");

						JsonNode geoCenterNode = pointNode.findPath("epsg:4326");

						int counter = 0;
						Double[] coords = new Double[2];

						for (JsonNode coord : geoCenterNode) {
							coords[counter] = coord.asDouble();

							counter++;

						}

						Double latitude = coords[1];
						Double longitude = coords[0];

						

						JsonNode speciesNode = lake.findPath("fishSpecies");

						HashSet<FishSpecies> fishes = new HashSet<FishSpecies>();

						for (JsonNode name : speciesNode) {
							String fish = name.asText();

							FishSpecies fishSpecies = new FishSpecies(fish);
							fishes.add(fishSpecies);
							System.out.println("species : " + fish);

						}

						if (fishes.size() > 0 && Double.compare(longitude, -89.47d) < 0 && Double.compare(longitude, -97.25d) > 0 
								&& Double.compare(latitude, 43.49d) > 0 && Double.compare(latitude, 49.39d) < 0){
							
							System.out.println("long: " + longitude.toString() + " lat: " + latitude.toString());
							
							Waterbody waterbody = new Waterbody("MN", "Minnesota", countyName, lakeName, acres,
									latitude, longitude);

							waterbody.addFishSpeciesList(fishes);

							waterbodies.add(waterbody);

						}

					}





			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		System.out.println(waterbodies);
		System.out.println("Minnesota lakes with fish: " + waterbodies.size());
		return waterbodies;

	}

}
