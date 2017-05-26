package com.misterhex.redditclone;

import com.misterhex.redditclone.repositories.TopicRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.junit.Assert.*;

/**
 * Created by yh.tan on 5/25/2017.
 */
public class TopicRepositoryTest {


    private TopicRepository repository;

    @Before
    public void setup(){
        repository = new TopicRepository();
    }

    @Test
    public void top20() throws Exception {

        List<String> headlines = IntStream.rangeClosed(0, 30).boxed().map(i -> "headline" + i.toString()).collect(Collectors.toList());

        List<Topic> topics = new ArrayList<>();

        for (String headline : headlines) {
            Topic t = repository.add(headline);
            topics.add(t);
        }

        repository.vote(new Vote(topics.get(9).getUuid(), "up"));
        repository.vote(new Vote(topics.get(9).getUuid(), "up"));
        repository.vote(new Vote(topics.get(9).getUuid(), "up"));
        repository.vote(new Vote(topics.get(9).getUuid(), "up"));
        repository.vote(new Vote(topics.get(9).getUuid(), "up"));

        repository.vote(new Vote(topics.get(10).getUuid(), "up"));
        repository.vote(new Vote(topics.get(10).getUuid(), "up"));
        repository.vote(new Vote(topics.get(10).getUuid(), "up"));
        repository.vote(new Vote(topics.get(10).getUuid(), "up"));

        repository.vote(new Vote(topics.get(15).getUuid(), "up"));
        repository.vote(new Vote(topics.get(15).getUuid(), "up"));
        repository.vote(new Vote(topics.get(15).getUuid(), "up"));

        repository.vote(new Vote(topics.get(8).getUuid(), "up"));
        repository.vote(new Vote(topics.get(8).getUuid(), "up"));

        repository.vote(new Vote(topics.get(0).getUuid(), "down"));
        repository.vote(new Vote(topics.get(0).getUuid(), "down"));

        repository.vote(new Vote(topics.get(1).getUuid(), "down"));

        List<Topic> top20 = repository.top20().stream().collect(Collectors.toList());

        assertEquals("headline9", top20.get(0).getHeadline());
        assertEquals("headline10", top20.get(1).getHeadline());
        assertEquals("headline15", top20.get(2).getHeadline());
        assertEquals("headline8", top20.get(3).getHeadline());

        assertTrue(top20.stream().allMatch(i-> i.getVote() >= 0));
    }

    @Test
    public void add() throws Exception {

        repository = new TopicRepository();

        List<String> headlines = IntStream.rangeClosed(1, 20).boxed().map(i -> "headline" + i.toString()).collect(Collectors.toList());

        for (String headline : headlines) {
            repository.add(headline);
        }

        assertEquals(20, repository.top20().size());
    }

    @Test
    public void remove() throws Exception {

        List<String> headlines = IntStream.rangeClosed(1, 30).boxed().map(i -> "headline" + i.toString()).collect(Collectors.toList());

        Topic last = null;
        for (String headline : headlines) {
            last = repository.add(headline);
        }

        UUID lastUuid = last.getUuid();
        repository.remove(lastUuid);

        assertFalse(repository.top20().stream().anyMatch(i-> i.getUuid() == lastUuid));
    }
}