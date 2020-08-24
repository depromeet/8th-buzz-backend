package com.depromeet.buzz.comment.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CommentLikeRepositoryTest {
	@Autowired
	CommentLikeRepository commentLikeRepository;

	@Test
	void findByUserIdAndCommentId() {
		commentLikeRepository.findByUserIdAndCommentId(1L, 1L);
	}
}