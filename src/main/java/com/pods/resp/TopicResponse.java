package com.pods.resp;

import java.util.UUID;

public class TopicResponse {
    
    private String name;
    private UUID id;

    public TopicResponse(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
