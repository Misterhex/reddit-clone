package com.misterhex.redditclone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TopicRepository implements ITopicRepository {

    private Object gate = new Object();
    private List<Topic> topics;

    public TopicRepository() {
        topics = new ArrayList<Topic>();
    }

    @Override
    public Collection<Topic> top20() {
        return topics.stream().sorted().limit(20).collect(Collectors.toList());
    }

    @Override
    public void addTopic(String headline) {
        synchronized (gate) {
            topics.add(new Topic(headline));
        }
    }
}
