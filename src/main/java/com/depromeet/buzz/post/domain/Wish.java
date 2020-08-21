package com.depromeet.buzz.post.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.depromeet.buzz.common.domain.BasicEntity;
import com.depromeet.buzz.user.domain.User;

@Entity
public class Wish extends BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;

	private Wish() {
	}

	public Wish(User user, Post post) {
		this.user = user;
		this.post = post;
	}

}
