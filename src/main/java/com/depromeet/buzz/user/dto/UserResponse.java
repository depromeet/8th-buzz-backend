package com.depromeet.buzz.user.dto;

import com.depromeet.buzz.user.domain.User;

public class UserResponse {
    private String userId;
    private String name;
    private String thumbnail;

    private UserResponse() {
    }

    private UserResponse(String userId, String name, String thumbnail) {
        this.userId = userId;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public static UserResponse from(User user) {
        return new UserResponse(user.getUserId(), user.getName(), user.getThumbnail());
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
