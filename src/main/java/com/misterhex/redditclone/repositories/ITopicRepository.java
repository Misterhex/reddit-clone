package com.misterhex.redditclone.repositories;

import com.misterhex.redditclone.Topic;
import com.misterhex.redditclone.Vote;

import java.util.Collection;
import java.util.UUID;

public interface ITopicRepository {
    Collection<Topic> top20();

    Topic add(String headline);

     boolean remove(UUID topicId);

    boolean isExist(UUID topicId);

    void vote(Vote vote);
}