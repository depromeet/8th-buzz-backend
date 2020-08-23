package com.depromeet.buzz.participation.domain;

import com.depromeet.buzz.common.domain.BasicEntity;
import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.user.domain.User;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Participation extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Post getPost() {
        return post;
    }

    public Participation() {
    }

    private Participation(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public static Participation participate(User user, Post post) {
        return new Participation(user, post);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participation that = (Participation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
