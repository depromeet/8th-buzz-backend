package com.depromeet.buzz.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class CommentResponse {
    private Long commentId;
    private String comment;
    private UserResponse user;
    private int numberOfWish;
    private int numberOfSubComments;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    private List<CommentResponse> comments;

    private CommentResponse() {
    }

    public CommentResponse(Long commentId, String comment, UserResponse user, int numberOfWish, int numberOfSubComments, LocalDateTime createdDate, List<CommentResponse> comments) {
        this.commentId = commentId;
        this.comment = comment;
        this.user = user;
        this.numberOfWish = numberOfWish;
        this.numberOfSubComments = numberOfSubComments;
        this.createdDate = createdDate;
        this.comments = comments;
    }

    public static CommentResponse mock(Long commentId, String comment, List<CommentResponse> comments) {
        return new CommentResponse(commentId,
            comment,
            new UserResponse(1L, "1"),
            14,
            comments.size(),
            LocalDateTime.of(2020, Month.AUGUST, 20, 10, 00, 00),
            comments
        );
    }

    private static class UserResponse {
        private Long userId;
        private String name;

        private UserResponse() {
        }

        public UserResponse(Long userId, String name) {
            this.userId = userId;
            this.name = name;
        }
    }
}
