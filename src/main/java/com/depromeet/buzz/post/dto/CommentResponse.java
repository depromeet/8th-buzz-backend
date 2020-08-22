package com.depromeet.buzz.post.dto;

import com.depromeet.buzz.comment.domain.Comment;
import com.depromeet.buzz.user.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentResponse {
    private Long commentId;
    private String comment;
    //댓글 작성자
    private Author author;
    private int numberOfWish;
    private int numberOfSubComments;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
    //현재 로그인된 사용자가 좋아요를 눌렀는지 여부
    private boolean isLiked;
    private List<CommentResponse> comments;

    private CommentResponse() {
    }

    public CommentResponse(Long commentId,
                           String comment,
                           Author author,
                           int numberOfWish,
                           int numberOfSubComments,
                           LocalDateTime createdDate,
                           boolean isLiked,
                           List<CommentResponse> comments) {
        this.commentId = commentId;
        this.comment = comment;
        this.author = author;
        this.numberOfWish = numberOfWish;
        this.numberOfSubComments = numberOfSubComments;
        this.createdDate = createdDate;
        this.isLiked = isLiked;
        this.comments = comments;
    }

    static CommentResponse mock(Long commentId, int numberOfWish, String comment, boolean isLiked, List<CommentResponse> comments) {
        return new CommentResponse(commentId,
            comment,
            new Author("1", "1"),
            numberOfWish,
            comments.size(),
            LocalDateTime.of(2020, Month.AUGUST, 20, 10, 00, 00),
            isLiked,
            comments
        );
    }

    public static CommentResponse from(Comment comment) {
        boolean isLiked = comment.getCommentLikes().stream()
            .anyMatch(commentLike -> commentLike.isAuthor(comment.getUser()));

        return new CommentResponse(
            comment.getId(),
            comment.getComment(),
            Author.from(comment.getUser()),
            comment.getCommentLikes().size(),
            comment.getSubComments() == null ? 0 : comment.getSubComments().size(),
            comment.getCreatedDate(),
            isLiked,
            comment.getSubComments() == null
                ? new ArrayList<>()
                : comment.getSubComments().stream().map(CommentResponse::from).collect(Collectors.toList())
        );

    }

    public static CommentResponse getPreviewComment(Comment comment) {
        boolean isLiked = comment.getCommentLikes().stream()
            .anyMatch(commentLike -> commentLike.isAuthor(comment.getUser()));

        return new CommentResponse(
            comment.getId(),
            comment.getComment(),
            Author.from(comment.getUser()),
            comment.getCommentLikes().size(),
            comment.getSubComments() == null ? 0 : comment.getSubComments().size(),
            comment.getCreatedDate(),
            isLiked,
            comment.getSubComments() == null
                ? new ArrayList<>()
                : comment.getSubComments().subList(0, getCommentsSize(comment.getSubComments())).stream().map(CommentResponse::getPreviewComment).collect(Collectors.toList())
        );
    }

    public Long getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public Author getAuthor() {
        return author;
    }

    public int getNumberOfWish() {
        return numberOfWish;
    }

    public int getNumberOfSubComments() {
        return numberOfSubComments;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }

    private static int getCommentsSize(List<Comment> subComments) {
        return Math.min(subComments.size(), 3);
    }

    private static class Author {
        private String userId;
        private String name;

        private Author() {
        }

        public Author(String userId, String name) {
            this.userId = userId;
            this.name = name;
        }

        public static Author from(User user) {
            return new Author(user.getUserId(), user.getName());
        }

        public String getUserId() {
            return userId;
        }

        public String getName() {
            return name;
        }
    }
}
