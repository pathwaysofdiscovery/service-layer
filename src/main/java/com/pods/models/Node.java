package com.pods.models;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.ArrayList;
import java.util.List;
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
    private String topicName;
    private int rating;
    private List<UUID> prereqs = new ArrayList<UUID>();
    private List<UUID> leadsto = new ArrayList<UUID>();

    public Node(UUID id, UUID topic_id, String description, String topicName, int rating, List<UUID> prereqs, List<UUID> leadsto) {
        this.id = id;
        this.topic_id = topic_id;
        this.description = description;
        this.topicName = topicName;
        this.rating = rating;
        this.prereqs = prereqs;
        this.leadsto = leadsto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<UUID> getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(List<UUID> prereqs) {
        this.prereqs = prereqs;
    }

    public List<UUID> getLeadsto() {
        return leadsto;
    }

    public void setLeadsto(List<UUID> leadsto) {
        this.leadsto = leadsto;
    }
}
