package com.depromeet.buzz.comment.repository;

import com.depromeet.buzz.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
