package com.depromeet.buzz.post.dto;


public class PostsRequest {
    private String category;

    private String sortOption;

    private PostsRequest() {
    }

    public PostsRequest(String category, String sortOption) {
        this.category = category;
        this.sortOption = sortOption;
    }

    public String getCategory() {
        return category;
    }

    public String getSortOption() {
        return sortOption;
    }
}
