package com.pods.resources;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NodesResponse {

    @SerializedName("nodes") private List<NodeResponse> nodes = new ArrayList<NodeResponse>();

    public NodesResponse(List<NodeResponse> nodes) {
        this.nodes = nodes;
    }

    public List<NodeResponse> getNodes() {
        return nodes;
    }
}
