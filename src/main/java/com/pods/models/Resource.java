package com.pods.models;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

/**
 * A resource for a topic
 */
@Table(keyspace="pods",name="resources")

public class Resource {

    @PartitionKey
    private UUID node_id;
    @ClusteringColumn
    private UUID id;
    private UUID topic_id;
    private String url;
    private String source;
    private int rating;
    private String title;

    public Resource(UUID id, UUID node_id, UUID topic_id, String url, String source, int rating, String title) {
        this.id = id;
        this.node_id = node_id;
        this.topic_id = topic_id;
        this.url = url;
        this.source = source;
        this.rating = rating;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getNode_id() {
        return node_id;
    }

    public void setNode_id(UUID node_id) {
        this.node_id = node_id;
    }

    public UUID getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(UUID topic_id) {
        this.topic_id = topic_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
