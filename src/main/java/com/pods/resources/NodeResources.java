package com.pods.resources;

import com.datastax.driver.mapping.Mapper;
import com.pods.models.Node;

public class NodeResources {
    private final Mapper<Node> nodeMapper;

    public NodeResources(Mapper<Node> nodeMapper) {
        this.nodeMapper = nodeMapper;
    }

}
