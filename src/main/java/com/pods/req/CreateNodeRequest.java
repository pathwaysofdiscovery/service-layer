package com.pods.req;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Set;

public class CreateNodeRequest {

    @SerializedName("description") private String description;
    @SerializedName("leadsto") private Set<String> leadsTo;
    @SerializedName("prereqs") private Set<String> prereqs;
    @SerializedName("rating") private int rating;
    @SerializedName("topic_id") private String topicId;
    @SerializedName("topic_name") private String topicName;

    public CreateNodeRequest(String description, Set<String> leadsTo, Set<String> prereqs, int rating, String topicId, String topicName) {
        this.description = description;
        this.leadsTo = leadsTo;
        this.prereqs = prereqs;
        this.rating = rating;
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getLeadsTo() {
        return leadsTo;
    }

    public Set<String> getPrereqs() {
        return prereqs;
    }

    public int getRating() {
        return rating;
    }

    public String getTopicId() {
        return topicId;
    }

    public String getTopicName() {
        return topicName;
    }
}
