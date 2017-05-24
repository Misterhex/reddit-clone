package com.misterhex.redditclone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by yh.tan on 5/24/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void top20_afterAddTopics_returnNumberOfCorrectTopics() throws Exception {

        Map<String, String> postBody = new HashMap<String, String>() {{
            put("headline", "hello world");
        }};

        ResponseEntity<Object> postResp = this.restTemplate.postForEntity("http://localhost:" + port + "/" + "api/topics", postBody, Object.class);

        assertEquals(postResp.getStatusCode(), HttpStatus.CREATED);

        ResponseEntity<Topic[]> getResp = this.restTemplate.getForEntity("http://localhost:" + port + "/" + "api/topics", Topic[].class);

        assertEquals(getResp.getStatusCode(), HttpStatus.OK);
        assertEquals(getResp.getBody().length, 1);
    }

    @Test
    public void createTopic() throws Exception {
    }

}