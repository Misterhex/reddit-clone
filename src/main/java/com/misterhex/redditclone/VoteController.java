package com.misterhex.redditclone;

import com.misterhex.redditclone.repositories.ITopicRepository;
import com.misterhex.redditclone.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by yh.tan on 5/24/2017.
 */
@RestController
@RequestMapping("api/votes")
public class VoteController {

    private ITopicRepository topicRepository;
    private String[] validVoteValues;

    @Autowired
    public VoteController(ITopicRepository topicRepository, @Qualifier("ValidVoteValues") String[] validVoteValues){
        this.topicRepository = topicRepository;
        this.validVoteValues = validVoteValues;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity VoteTopic(@RequestBody  Vote vote){
        if (vote == null)
            throw new IllegalArgumentException();

        if (!Arrays.stream(this.validVoteValues).anyMatch(i-> i.equals(vote.getVoteType())))
            throw new IllegalArgumentException();

        topicRepository.vote(vote);

        return ResponseEntity.ok().build();
    }
}



