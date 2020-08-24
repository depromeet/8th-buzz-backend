package com.depromeet.buzz.comment.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.depromeet.buzz.comment.domain.Comment;
import com.depromeet.buzz.comment.domain.CommentLike;
import com.depromeet.buzz.comment.domain.QCommentLike;

public class CommentLikeRepositoryCustomImpl extends QuerydslRepositorySupport implements CommentLikeRepositoryCustom {

	public CommentLikeRepositoryCustomImpl() {
		super(Comment.class);
	}

	@Override
	public CommentLike findByUserIdAndCommentId(Long userId, Long commentId) {
		QCommentLike commentLike = QCommentLike.commentLike;

		return from(commentLike)
			.where(commentLike.comment.id.eq(commentId)
				.and(commentLike.user.id.eq(userId)))
			.fetchOne();
	}

}
