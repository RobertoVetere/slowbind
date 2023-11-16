package com.gruponueve.slowbind;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class SlowBindApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlowBindApplication.class, args);
	}

}
