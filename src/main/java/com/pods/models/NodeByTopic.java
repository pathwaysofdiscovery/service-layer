package com.pods.models;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

/**
 * A specific node within a topic
 */
@Table(keyspace="pods",name="nodes_by_topic")
public class NodeByTopic {

    @PartitionKey
    private UUID topicId;
    @Column(name="id")
    private UUID id;

    public NodeByTopic(UUID id, UUID topic_id) {
        this.id = id;
        this.topicId = topic_id;
    }

    public NodeByTopic() {
    }

    public NodeByTopic(Node node) {
        this.topicId = node.getTopicId();
        this.id = node.getId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public void setTopicId(UUID topicId) {
        this.topicId = topicId;
    }
}
