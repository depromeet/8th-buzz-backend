package com.depromeet.buzz.comment.domain;

import com.depromeet.buzz.common.domain.BasicEntity;
import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.user.domain.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Comment extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.REMOVE)
    private List<Comment> subComments;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parentComment;

    private Comment() {
    }

    public Comment(String comment, User user, Post post) {
        validate(comment, user);
        this.comment = comment;
        this.user = user;
        this.post = post;
    }

    private void validate(String comment, User user) {
        Objects.requireNonNull(comment, "코멘트가 없습니다.");
        Objects.requireNonNull(user, "사용자가 없습니다.");
    }

    public void addParent(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public boolean isEnableDelete(User user) {
        return this.user.equals(user);
    }

    public Long getId() {
        return Id;
    }

    public String getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public List<Comment> getSubComments() {
        return subComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(Id, comment.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Comment{" +
            "Id=" + Id +
            ", comment='" + comment + '\'' +
            ", user=" + user +
            ", subComments=" + subComments +
            ", parentComment=" + parentComment +
            '}';
    }
}