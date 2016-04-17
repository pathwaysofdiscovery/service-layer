package com.pods.models;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

/**
 * A specific node within a topic
 */
@Table(keyspace="pods",name="nodes")
public class Node {

    @PartitionKey
    private UUID id;
    @Column(name="topic_id")
    private UUID topic_id;
    @Column(name="description")
    private String description;

    public Node(UUID id, UUID topic_id, String description) {
        this.id = id;
        this.topic_id = topic_id;
        this.description = description;
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

    public UUID getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(UUID topic_id) {
        this.topic_id = topic_id;
    }
}
