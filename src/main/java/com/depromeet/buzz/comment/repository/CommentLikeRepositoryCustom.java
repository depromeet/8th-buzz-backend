package com.depromeet.buzz.comment.repository;

import com.depromeet.buzz.comment.domain.CommentLike;

public interface CommentLikeRepositoryCustom {
	CommentLike findByUserIdAndCommentId(Long userId, Long commentId);
}
