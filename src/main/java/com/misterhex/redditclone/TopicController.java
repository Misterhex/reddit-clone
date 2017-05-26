package com.misterhex.redditclone;

import com.misterhex.redditclone.repositories.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private ITopicRepository topicRepository;

    @Autowired
    public TopicController(ITopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @RequestMapping(path = "top20", method = RequestMethod.GET)
    public ResponseEntity<Collection<Topic>> top20() {
        Collection<Topic> top20 = this.topicRepository.top20();
        return ResponseEntity.ok(top20);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createTopic(@RequestBody Map<String,String> body) {
        if (body == null || body.get("headline") == null || body.get("headline").length() > 255) {
            return ResponseEntity.badRequest().build();
        }

        this.topicRepository.add(body.get("headline"));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
