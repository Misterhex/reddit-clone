package com.misterhex.redditclone;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

/**
 * Created by yh.tan on 5/24/2017.
 */
@RestController
@RequestMapping("api/votes")
public class VoteController {

    private TopicRepository topicRepository;

    public VoteController(TopicRepository topicRepository){

        this.topicRepository = topicRepository;
    }

//    @RequestMapping()
//    public ResponseEntity Vote(){
//
//    }
}

