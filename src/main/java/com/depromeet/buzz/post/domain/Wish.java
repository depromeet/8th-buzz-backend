package com.depromeet.buzz.post.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.depromeet.buzz.common.domain.BasicEntity;
import com.depromeet.buzz.user.domain.User;

import java.util.Objects;

@Entity
public class Wish extends BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;

	public Wish() {
	}

	public Wish(User user, Post post) {
		this.user = user;
		this.post = post;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Wish wish = (Wish) o;
		return Objects.equals(Id, wish.Id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}
}
