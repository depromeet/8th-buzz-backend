package com.depromeet.buzz.participation.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.user.domain.User;

@Entity
public class Participation {

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

	private Participation() {}

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
		Participation that = (Participation)o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Participation{" +
			"id=" + id +
			", user=" + user +
			", post=" + post +
			'}';
	}

}
