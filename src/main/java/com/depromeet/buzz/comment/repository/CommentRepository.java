package com.depromeet.buzz.comment.repository;

import com.depromeet.buzz.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
    Optional<Comment> findById(Long commentId);

    int countAllByPostId(Long postId);

    List<Comment> findAllByPostId(Long postId);
}
