package com.misterhex.redditclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private ITopicRepository topicRepository;

    @Autowired
    public TopicController(ITopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Topic>> Top20() {
        Collection<Topic> top20 = this.topicRepository.Top20();
        return ResponseEntity.ok(top20);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity CreateTopic(@RequestBody String headline) {
        if (headline.isEmpty() || headline.length() > 255) {
            return ResponseEntity.badRequest().build();
        }

        boolean isCreated = this.topicRepository.TryAddTopic();

        if (isCreated)
            return ResponseEntity.status(HttpStatus.CREATED).build();
        else
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
