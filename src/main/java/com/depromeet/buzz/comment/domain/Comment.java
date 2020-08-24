package com.depromeet.buzz.comment.domain;

import com.depromeet.buzz.common.domain.BasicEntity;
import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.user.domain.User;
import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Comment extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.REMOVE)
    @OrderBy("createdDate desc")
    private List<Comment> subComments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<CommentLike> commentLikes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment parentComment;

    public Comment() {
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
        return id;
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

    public Post getPost() {
        return post;
    }

    public List<CommentLike> getCommentLikes() {
        return commentLikes;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public boolean hasParent() {
        return this.parentComment != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Comment{" +
            "id=" + id +
            ", comment='" + comment + '\'' +
            '}';
    }
}