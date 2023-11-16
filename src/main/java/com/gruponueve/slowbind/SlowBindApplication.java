package com.gruponueve.slowbind;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gruponueve.slowbind.models.InterestPoint;
import com.gruponueve.slowbind.services.InterestPointService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class SlowBindApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlowBindApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(InterestPointService interestPointService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<InterestPoint>> typeReference=new TypeReference<List<InterestPoint>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/skins.json");
			try {
				List<InterestPoint> interestPoints = mapper.readValue(inputStream,typeReference);
				InterestPointService.saveInterestPoint(interestPoints);
				System.out.println("Interest points saved");
			} catch (IOException e){
				System.out.println("Unable to save interest points: " + e.getMessage());
			}
		};
}
