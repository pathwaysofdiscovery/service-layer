package com.pods.resp;

import com.pods.models.Topic;

import java.util.UUID;

public class TopicResponse {
    private final String imageUrl;
    private final UUID id;
    private final String description;
    private final String name;

    public TopicResponse(Topic topic) {
        this.id = topic.getId();
        this.description = topic.getDescription();
        this.name = topic.getTopicName();
        this.imageUrl = topic.getImageUrl();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
