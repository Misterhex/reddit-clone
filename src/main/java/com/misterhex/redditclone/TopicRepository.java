package com.misterhex.redditclone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TopicRepository implements ITopicRepository
{
    @Override
    public Collection<Topic> Top20() {
        List<Topic> topics = new ArrayList<Topic>();
        topics.add(new Topic("Stack Overflow: Helping One Million Developers Exit Vim"));
        return topics;
    }

    @Override
    public Boolean TryAddTopic() {
        return true;
    }
}
