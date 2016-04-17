package com.pods.models;

import java.util.UUID;

/**
 * A top-level topic of interest.
 */
public class Topic {

    private String topicName;
    private UUID id;

    public Topic(String topicName, UUID id) {
        this.topicName = topicName;
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
