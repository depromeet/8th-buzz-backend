package com.depromeet.buzz.comment.dto;

public class CommentCreateRequest {
    private Long postId;
    private Long commentId;
    private String userId;
    private String content;

    private CommentCreateRequest() {
    }

    public CommentCreateRequest(Long postId, Long commentId, String userId, String content) {
        this.postId = postId;
        this.commentId = commentId;
        this.userId = userId;
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public String getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }
}
