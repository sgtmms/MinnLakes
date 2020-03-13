package net.mims.minnlakes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;


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
			MinnLakeLoader minnLakeLoader = new MinnLakeLoader();
			minnLakeLoader.retrieveDataAndSaveToDatabase();
		};
	}
}
