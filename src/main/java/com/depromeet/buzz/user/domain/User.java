package com.depromeet.buzz.user.domain;

import com.depromeet.buzz.common.domain.BasicEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;

    private String name;

    private User() {
    }

    public User(String userId, String name) {
        if (Objects.isNull(userId) || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("userId is empty");
        }

        this.userId = userId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' + '}';
    }

}
