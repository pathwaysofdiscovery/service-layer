package com.pods.models;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

/**
 * A top-level topic of interest.
 */
@Table(keyspace="pods",name="topics")
public class Topic {

    @PartitionKey
    private UUID id;
    @Column(name="name")
    private String topicName;
    @Column(name="description")
    private String description;
    @Column(name="image_url")
    private String imageUrl;

    public Topic() {

    }
    public Topic(String topicName, String description, UUID id, String imageUrl) {
        this.topicName = topicName;
        this.description = description;
        this.id = id;
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
