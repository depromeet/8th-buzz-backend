package com.depromeet.buzz.user.dto;

public class UserResponse {
    private String userId;
    private String name;

    private UserResponse() {
    }

    private UserResponse(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public static UserResponse mock(String userId) {
        return new UserResponse(userId, String.format("유저이름 %s", userId));
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
