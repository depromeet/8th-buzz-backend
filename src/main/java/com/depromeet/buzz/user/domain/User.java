package com.depromeet.buzz.user.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String userId;

	private String name;

	private User() { }

	public User(String userId, String name) {
		if(Objects.isNull(userId) || userId.trim().isEmpty()) {
			throw new IllegalArgumentException("userId 없음");
		}

		this.userId = userId;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

}
