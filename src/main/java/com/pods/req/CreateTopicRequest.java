package com.pods.req;

import com.google.gson.annotations.SerializedName;

public class CreateTopicRequest {
    @SerializedName("name") private final String name;
    @SerializedName("description") private final String description;
    @SerializedName("image_url") private final String imageUrl;

    public CreateTopicRequest(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
