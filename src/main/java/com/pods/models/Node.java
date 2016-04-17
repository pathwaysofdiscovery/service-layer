package com.pods.models;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.*;

/**
 * A specific node within a topic
 */
@Table(keyspace="pods",name="nodes")
public class Node {

    @PartitionKey
    private UUID id;
    @Column(name="topic_id")
    private UUID topicId;
    @Column(name="description")
    private String description;
    private String topicName;
    private int rating;
    private Set<UUID> prereqs = new HashSet<UUID>();
    private Set<UUID> leadsto = new HashSet<UUID>();

    public Node(UUID id, UUID topic_id, String description, String topicName, int rating, Set<UUID> prereqs, Set<UUID> leadsto) {
        this.id = id;
        this.topicId = topic_id;
        this.description = description;
        this.topicName = topicName;
        this.rating = rating;
        this.prereqs = prereqs;
        this.leadsto = leadsto;
    }

    public Node() {
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

    public Set<UUID> getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(Set<UUID> prereqs) {
        this.prereqs = prereqs;
    }

    public Set<UUID> getLeadsto() {
        return leadsto;
    }

    public void setLeadsto(Set<UUID> leadsto) {
        this.leadsto = leadsto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return id != null ? id.equals(node.id) : node.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
