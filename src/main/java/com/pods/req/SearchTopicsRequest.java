package com.pods.req;

import com.google.gson.annotations.SerializedName;

public class SearchTopicsRequest {
    @SerializedName("search_pattern") private String searchPattern;

    public SearchTopicsRequest(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    public String getSearchPattern() {
        return searchPattern;
    }
}
