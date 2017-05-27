package com.misterhex.redditclone;

import java.util.UUID;

public class Topic {

    private UUID uuid;

    private String headline;

    private int vote;

    private boolean isDeleted = false;

    public Topic(){ }

    public Topic(String headline){
        this.uuid = UUID.randomUUID();
        this.headline = headline;
        this.vote = 0;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object obj) {
        Topic t = (Topic)obj;
        return t.getUuid().equals(this.getUuid());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Topic Copy()
    {
        Topic c = new Topic(){ };
        c.setUuid(this.uuid);
        c.setHeadline(this.headline);
        c.setVote(this.vote);
        return c;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
