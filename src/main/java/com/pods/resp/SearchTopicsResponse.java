package com.pods.resp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchTopicsResponse {

    private List<TopicResponse> topicList = new ArrayList<>();

    public SearchTopicsResponse(List<TopicResponse> topicList) {
        this.topicList = topicList;
    }

    public List<TopicResponse> getTopics() {
        return Collections.unmodifiableList(topicList);
    }
}
