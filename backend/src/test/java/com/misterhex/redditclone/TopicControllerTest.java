package com.misterhex.redditclone;

import com.misterhex.redditclone.models.Topic;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    final Map<String, String> postBody = new HashMap<String, String>() {{
        put("headline", "hello world");
    }};

    String endpoint;

    @Before
    public void setUp() throws Exception {
        endpoint = "http://localhost:" + port + "/" + "api/topics/";

        ResponseEntity<Topic[]> getResp = this.restTemplate.getForEntity(endpoint, Topic[].class);
    }

    @Test
    @DirtiesContext
    public void top20_afterAddTopics_returnNumberOfCorrectTopics() throws Exception {

        ResponseEntity<Object> postResp = this.restTemplate.postForEntity(endpoint, postBody, Object.class);
        assertEquals(postResp.getStatusCode(), HttpStatus.CREATED);

        ResponseEntity<Topic[]> getResp = this.restTemplate.getForEntity(endpoint, Topic[].class);

        assertEquals(getResp.getStatusCode(), HttpStatus.OK);
        Topic[] topics = getResp.getBody();
        assertEquals(topics.length, 1);
    }

    @Test
    @DirtiesContext
    public void createTopic_validBody_returnHttpCreated() throws Exception {

        ResponseEntity<Object> postResp = this.restTemplate.postForEntity(endpoint, postBody, Object.class);

        assertEquals(postResp.getStatusCode(), HttpStatus.CREATED);

    }

    @Test
    @DirtiesContext
    public void createTopic_invalidBody_badRequest() throws Exception {

        HashMap<String, String> hashMap = new HashMap<>();

        ResponseEntity<Object> postResp = this.restTemplate.postForEntity(endpoint, hashMap, Object.class);

        assertEquals(HttpStatus.BAD_REQUEST, postResp.getStatusCode());
    }
}