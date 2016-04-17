package com.pods.models;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

/**
 * A resource for a topic
 */
@Table(keyspace="pods",name="resources")

public class Resource {

    @PartitionKey
    @Column(name="node_id")
    private UUID nodeId;
    @ClusteringColumn
    private UUID id;
    @Column(name="topic_id")
    private UUID topicId;
    @Column(name="content_url")
    private String contentUrl;
    @Column(name="source")
    private String source;
    @Column(name="rating")
    private int rating;
    @Column(name="title")
    private String title;

    public Resource(UUID id, UUID node_id, UUID topic_id, String contentUrl, String source, int rating, String title) {
        this.id = id;
        this.nodeId = node_id;
        this.topicId = topic_id;
        this.contentUrl = contentUrl;
        this.source = source;
        this.rating = rating;
        this.title = title;
    }

    public Resource() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getNodeId() {
        return nodeId;
    }

    public void setNodeId(UUID nodeId) {
        this.nodeId = nodeId;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
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
