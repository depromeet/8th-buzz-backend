package com.depromeet.buzz.comment.repository;

import java.util.List;

import com.depromeet.buzz.comment.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepositoryCustom {
    Page<Comment> findCommentsByPostId(Long postId, Pageable pageable);

    List<Comment> findPopularCommentsByPostId(Long postId);
}
