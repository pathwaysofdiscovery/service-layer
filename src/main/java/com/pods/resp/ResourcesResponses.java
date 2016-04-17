package com.pods.resp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResourcesResponses {

    @SerializedName("resources")
    private List<ResourceResponse> resources = new ArrayList<ResourceResponse>();

    public ResourcesResponses(List<ResourceResponse> resources) {
        this.resources = resources;
    }

    public List<ResourceResponse> getResources() {
        return resources;
    }
}
