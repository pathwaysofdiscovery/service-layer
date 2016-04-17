package com.pods.resp;

import com.pods.models.Resource;

import java.util.UUID;

public class ResourceResponse {

    private final UUID id;
    private final int rating;
    private final UUID nodeId;
    private final String source;
    private final String title;
    private final UUID topicId;
    private final String contentUrl;
    private final String resourceUrl;

    public ResourceResponse(Resource resource, String resourceUrl) {

        this.id = resource.getId();
        this.rating = resource.getRating();
        this.nodeId = resource.getNodeId();
        this.source = resource.getSource();
        this.title = resource.getTitle();
        this.topicId = resource.getTopicId();
        this.contentUrl = resource.getContentUrl();
        this.resourceUrl = resourceUrl;
    }

    public UUID getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public UUID getNodeId() {
        return nodeId;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }
}
