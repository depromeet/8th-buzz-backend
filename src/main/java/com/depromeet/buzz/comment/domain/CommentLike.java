package com.depromeet.buzz.comment.domain;

import com.depromeet.buzz.user.domain.User;

import javax.persistence.*;

@Entity
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;

    private CommentLike() {
    }

    public CommentLike(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }
}
