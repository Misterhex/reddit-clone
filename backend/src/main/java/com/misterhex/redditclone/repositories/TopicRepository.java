package com.misterhex.redditclone.repositories;

import com.misterhex.redditclone.models.Topic;
import com.misterhex.redditclone.models.Vote;

import java.util.*;

public class TopicRepository implements ITopicRepository {

    private TreeSet<Topic> treeSet;
    private HashMap<UUID, Topic> hashMap;

    public TopicRepository() {
        treeSet = new TreeSet<>((o1, o2) -> o1.getVote() > o2.getVote() ? 1 : -1);
        hashMap = new HashMap<>();
    }

    @Override
    public Collection<Topic> top20() {

        Iterator<Topic> iterator = treeSet.descendingIterator();
        List<Topic> lst = new ArrayList<>();
        while(iterator.hasNext() && lst.size() < 20)
        {
            Topic t = iterator.next();
            if (t != null && !t.isDeleted()) {
                lst.add(t);
            }
        }

        return lst;
    }

    @Override
    public Topic add(String headline) {
        Topic t = new Topic(headline);
        hashMap.put(t.getUuid(), t);
        treeSet.add(t);
        return t;
    }

    @Override
    public boolean remove(UUID topicId) {

        Topic t = hashMap.get(topicId);

        if (t == null)
            return false;

        t.setDeleted(true);

        return true;
    }

    @Override
    public boolean isExist(UUID topicId) {
        return hashMap.containsKey(topicId);
    }

    @Override
    public void vote(Vote vote) {

        Topic t = hashMap.get(vote.getTopicId());

        if (t == null || t.isDeleted())
            throw new IllegalStateException();

        Topic copy = t.Copy();
        t.setDeleted(true);

        if (vote.getVoteType().equals("up"))
            copy.setVote(copy.getVote() + 1);
        else if (vote.getVoteType().equals("down"))
            copy.setVote(copy.getVote() - 1);
        else
            throw new IllegalStateException();

        treeSet.add(copy);
        hashMap.put(copy.getUuid(), copy);
    }
}
