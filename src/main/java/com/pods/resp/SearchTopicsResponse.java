package com.pods.resp;

import com.pods.models.Topic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTopicsResponse {

    private List<Topic> topicList = new ArrayList<>();

    public SearchTopicsResponse(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<Topic> getTopics() {
        return Collections.unmodifiableList(topicList);
    }
}
