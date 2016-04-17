package com.pods.models;

import java.util.UUID;

/**
 * A resource for a topic
 */
public class Resource {
    private UUID topic_id;
    private String description;
    private String url;

    public Resource(UUID topic_id, String description, String url) {
        this.topic_id = topic_id;
        this.description = description;
        this.url = url;
    }

    public UUID getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(UUID topic_id) {
        this.topic_id = topic_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
