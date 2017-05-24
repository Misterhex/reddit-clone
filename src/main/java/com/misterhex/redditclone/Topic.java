package com.misterhex.redditclone;

import java.util.UUID;

public class Topic {

    private UUID uuid;

    private String headline;

    private int vote;

    public Topic(){ }

    public Topic(String headline){
        this.uuid = UUID.randomUUID();
        this.headline = headline;
        this.vote = 0;
    }

    public String getHeadline() {
        return headline;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getVote() {
        return vote;
    }
}
