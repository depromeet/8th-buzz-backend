package com.depromeet.buzz.post.dto;


public class PostsRequest {
    private String keyword;

    private String category;

    private String sortOption;

    private PostsRequest() {
    }

    public PostsRequest(String keyword, String category, String sortOption) {
        this.keyword = keyword;
        this.category = category;
        this.sortOption = sortOption;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getCategory() {
        return category;
    }

    public String getSortOption() {
        return sortOption;
    }
}
