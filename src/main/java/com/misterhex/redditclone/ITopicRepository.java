package com.misterhex.redditclone;

import java.util.Collection;

/**
 * Created by yh.tan on 5/24/2017.
 */
public interface ITopicRepository {
    Collection<Topic> top20();

    void addTopic(String headline);
}