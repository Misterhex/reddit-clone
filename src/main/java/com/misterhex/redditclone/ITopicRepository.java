package com.misterhex.redditclone;

import java.util.Collection;
import java.util.UUID;

/**
 * Created by yh.tan on 5/24/2017.
 */
public interface ITopicRepository {
    Collection<Topic> top20();

    Topic add(String headline);

     boolean remove(UUID topicId);

    boolean IsExist(UUID topicId);

    void vote(Vote vote);
}