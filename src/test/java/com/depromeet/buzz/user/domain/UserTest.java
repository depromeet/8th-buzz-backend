package com.depromeet.buzz.user.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void userId가_없을때_생성안됨() {
		assertThrows(IllegalArgumentException.class, () -> new User(null, "name", "thumbnail"));
	}

	@Test
	void userId가_빈문자열일때_생성안됨() {
		assertThrows(IllegalArgumentException.class, () -> new User("", "name", "thumbnail"));
	}

}
