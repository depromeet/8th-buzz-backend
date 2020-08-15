package com.depromeet.buzz.post.dto;

public class PostDetailResponse {
    private String name;

    private PostDetailResponse() {
    }

    public PostDetailResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
