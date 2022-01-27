package net.mims.minnlakes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class MinnLakesApplication {

	private static final Logger log = LoggerFactory.getLogger(MinnLakesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MinnLakesApplication.class, args);
	}

	@Bean
	public WebClient getWebClientBuilder(){
		return   WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
						.codecs(configurer -> configurer
								.defaultCodecs()
								.maxInMemorySize(16 * 1024 * 1024))
						.build())
				.build();
	}


	@SuppressWarnings({ "unchecked", "null" })
	@Bean
	public CommandLineRunner run(WebClient webClient) throws Exception {
		return args -> {
			MinnLakeLoader minnLakeLoader = new MinnLakeLoader(webClient);
			minnLakeLoader.retrieveDataAndSaveToDatabase();
		};
	}
}
