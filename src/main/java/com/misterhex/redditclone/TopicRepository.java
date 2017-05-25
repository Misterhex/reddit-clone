package com.misterhex.redditclone;

import java.util.*;
import java.util.stream.Collectors;

public class TopicRepository implements ITopicRepository {

    private Object gate = new Object();

    private TreeSet<Topic> treeSet;
    private HashMap<UUID, Topic> hashMap;

    public TopicRepository() {
        treeSet = new TreeSet<>((o1, o2) -> o1.getVote() > o2.getVote() ? -1 : 1);
        hashMap = new HashMap<>();
    }

    @Override
    public Collection<Topic> top20() {
        return treeSet.stream().collect(Collectors.toList());
    }

    @Override
    public Topic add(String headline) {
        Topic t = new Topic(headline);
        hashMap.put(t.getUuid(), t);
        treeSet.add(t);
        TrimSet();
        return t;
    }

    public boolean remove(UUID topicId) {

        Topic t = hashMap.remove(topicId);

        if (t == null)
            return false;

        TrimSet();
        return true;
    }

    public boolean IsExist(UUID topicId) {
        return hashMap.containsKey(topicId);
    }

    public void vote(Vote vote) {

        Topic t = hashMap.get(vote.getTopicId());

        if (t == null)
            throw new IllegalStateException();

        if (vote.getVoteType().equals("up"))
            t.setVote(t.getVote() + 1);
        else if (vote.getVoteType().equals("down"))
            t.setVote(t.getVote() - 1);
        else
            throw new IllegalStateException();

        // re-sort.
        this.treeSet.removeIf(i-> i.getUuid() == vote.getTopicId());
        this.treeSet.add(t);
    }

    private void TrimSet() {

        Iterator<Topic> iterator = this.treeSet.descendingIterator();

        List<Topic> lst = new ArrayList<>();
        while (iterator.hasNext() && lst.size() < 20) {
            Topic t = iterator.next();
            if (t != null)
                lst.add(t);
        }

        this.treeSet.clear();
        this.treeSet.addAll(lst);
    }
}
