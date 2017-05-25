package com.misterhex.redditclone;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by yh.tan on 5/25/2017.
 */
public class TopicRepositoryTest {

    @Test
    public void top20() throws Exception {

        TopicRepository repository = new TopicRepository();

        List<String> headlines = IntStream.rangeClosed(0, 30).boxed().map(i -> "headline" + i.toString()).collect(Collectors.toList());

        List<Topic> topics = new ArrayList<>();

        for (String headline : headlines) {
            Topic t = repository.add(headline);
            topics.add(t);
        }

        repository.vote(new Vote(topics.get(10).getUuid(), "up"));
        repository.vote(new Vote(topics.get(10).getUuid(), "up"));
        repository.vote(new Vote(topics.get(10).getUuid(), "up"));
        repository.vote(new Vote(topics.get(10).getUuid(), "up"));

        repository.vote(new Vote(topics.get(15).getUuid(), "up"));
        repository.vote(new Vote(topics.get(15).getUuid(), "up"));
        repository.vote(new Vote(topics.get(15).getUuid(), "up"));


        repository.vote(new Vote(topics.get(9).getUuid(), "up"));
        repository.vote(new Vote(topics.get(9).getUuid(), "up"));
        repository.vote(new Vote(topics.get(9).getUuid(), "up"));
        repository.vote(new Vote(topics.get(9).getUuid(), "up"));
        repository.vote(new Vote(topics.get(9).getUuid(), "up"));

        repository.vote(new Vote(topics.get(8).getUuid(), "up"));
        repository.vote(new Vote(topics.get(8).getUuid(), "up"));

        repository.vote(new Vote(topics.get(5).getUuid(), "down"));

        Collection<Topic> sorted = repository.top20();
    }

    @Test
    public void add() throws Exception {

        TopicRepository repository = new TopicRepository();

        List<String> headlines = IntStream.rangeClosed(1, 30).boxed().map(i -> "headline" + i.toString()).collect(Collectors.toList());

        for (String headline : headlines) {
            repository.add(headline);
        }
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void tryVote() throws Exception {
    }

}