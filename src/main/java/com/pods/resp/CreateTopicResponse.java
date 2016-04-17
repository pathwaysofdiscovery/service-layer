package com.pods.resp;

import java.util.UUID;

public class CreateTopicResponse {
    private String name;
    private String description;
    private String imageUrl;
    private UUID id;

    public CreateTopicResponse(String name, String description, String imageUrl, UUID id) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UUID getId() {
        return id;
    }
}
