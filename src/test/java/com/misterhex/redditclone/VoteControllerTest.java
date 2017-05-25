package com.misterhex.redditclone;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by yh.tan on 5/25/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VoteControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String topicEndpoint;
    private String voteEndpoint;

    @Before
    public void setUp() throws Exception {
        topicEndpoint = new String("http://localhost:" + port + "/" + "api/topics/");
        voteEndpoint = new String("http://localhost:" + port + "/" + "api/votes/");

        Map<String, String> postBody = new HashMap<String, String>() {{
            put("headline", "hello world");
        }};

        // create 1 topic
        ResponseEntity<String> resp = restTemplate.postForEntity(this.topicEndpoint, postBody, String.class);

        if (resp.getStatusCode() != HttpStatus.CREATED)
            throw new Exception();
    }

    @Test
    public void voteTopic_upvote_topicVoteIncreased() throws Exception {

        // get created topic
        Topic[] topics = this.restTemplate.getForObject(new URI(topicEndpoint + "top20"), Topic[].class);
        UUID topicId = topics[0].getUuid();

        HttpEntity<Vote> httpEntity = new HttpEntity<Vote>(new Vote(topicId, "up"));

        ResponseEntity<Object> resp = this.restTemplate.postForEntity(this.voteEndpoint, httpEntity, Object.class);
        assertEquals(resp.getStatusCode(), HttpStatus.CREATED);
    }

}