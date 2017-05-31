package com.misterhex.redditcloneintegrationtests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class IntegrationTests {

	public static void main(String[] args) {

        SpringApplication app = new SpringApplication(IntegrationTests.class);
        app.setWebEnvironment(false);
        app.run(args);
	}

	@Bean
    public RestTemplate restTemplate(){
	    return new RestTemplate();
    }
}

