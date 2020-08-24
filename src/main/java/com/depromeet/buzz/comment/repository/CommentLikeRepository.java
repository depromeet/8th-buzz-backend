package com.depromeet.buzz.comment.repository;

import com.depromeet.buzz.comment.domain.CommentLike;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike, Long>, CommentLikeRepositoryCustom {
}
