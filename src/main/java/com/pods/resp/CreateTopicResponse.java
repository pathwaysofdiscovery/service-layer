package com.pods.resp;

import java.util.UUID;

public class CreateTopicResponse {
    private final String resourceUrl;
    private String name;
    private String description;
    private String imageUrl;
    private UUID id;

    public CreateTopicResponse(String name, String description, String imageUrl, UUID id, String resourceUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.id = id;
        this.resourceUrl = resourceUrl;
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

    public String getResourceUrl() {
        return resourceUrl;
    }
}
