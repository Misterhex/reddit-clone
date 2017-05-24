package com.misterhex.redditclone;

import java.util.UUID;

public class Topic {

    private UUID uuid;

    private String headline;

    public Topic(String headline){
        this.uuid = UUID.randomUUID();
        this.headline = headline;
    }

    public String getHeadline() {
        return headline;
    }

    public UUID getUuid() {
        return uuid;
    }
}
