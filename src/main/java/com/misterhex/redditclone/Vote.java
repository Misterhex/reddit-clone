package com.misterhex.redditclone;

import java.util.UUID;

public class Vote
{
    private UUID topicId;
    private String voteType;

    public Vote(){

    }

    public Vote(UUID topicId, String voteType)
    {
        this.topicId = topicId;
        this.voteType = voteType;
    }

    public String getVoteType() {
        return voteType;
    }

    public UUID getTopicId() {
        return topicId;
    }
}
