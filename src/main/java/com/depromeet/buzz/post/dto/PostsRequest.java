package com.depromeet.buzz.post.dto;


import com.depromeet.buzz.post.domain.Sort;

public class PostsRequest {
    private String keyword;

    private String category;

    private Sort sortOption;

    private PostsRequest() {
    }

    public PostsRequest(String keyword, String category, Sort sortOption) {
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

    public Sort getSortOption() {
        return sortOption;
    }
}
