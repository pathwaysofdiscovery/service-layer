package com.pods.resources;

import com.pods.models.Node;

import java.util.Set;
import java.util.UUID;

public class NodeResponse {

    private final UUID nodeId;
    private final String description;
    private final UUID topicId;
    private final String topicName;
    private final Set<UUID> prereqs;
    private final Set<UUID> leadsTo;
    private final int rating;
    private final String resourceUrl;

    public NodeResponse(Node node, String resourceUrl) {
        this.nodeId = node.getId();
        this.description = node.getDescription();
        this.topicName = node.getTopicName();
        this.leadsTo = node.getLeadsto();
        this.prereqs = node.getPrereqs();
        this.rating = node.getRating();
        this.topicId = node.getTopicId();
        this.resourceUrl = resourceUrl;
    }

    public UUID getNodeId() {
        return nodeId;
    }

    public String getDescription() {
        return description;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public Set<UUID> getPrereqs() {
        return prereqs;
    }

    public Set<UUID> getLeadsTo() {
        return leadsTo;
    }

    public int getRating() {
        return rating;
    }
}
