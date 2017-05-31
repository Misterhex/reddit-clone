package com.misterhex.redditcloneintegrationtests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
    private RestTemplate restTemplate;
    private String topicApiEndpoint;

    @Autowired
    public CommandLineAppStartupRunner(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
        this.topicApiEndpoint = "http://localhost:8080" + "/" + "api/topics/";
    }

    @Override
    public void run(String...args) throws Exception {
        List<String> headlines = IntStream.range(0, 50).boxed().map(i-> String.format("topic %d", i)).collect(Collectors.toList());

        for (String headline : headlines) {

            HashMap<String,String> postData = new HashMap<>();
            postData.put("headline", headline);

            this.restTemplate.postForEntity(new URI(topicApiEndpoint), postData, Object.class);
            logger.info(String.format("added %d topic...", headline));
        }

        logger.info(String.format("completed adding %d topics...", headlines.size()));
    }
}
