package com.depromeet.buzz.comment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.depromeet.buzz.comment.domain.Comment;
import com.depromeet.buzz.comment.domain.CommentLike;
import com.depromeet.buzz.comment.repository.CommentLikeRepository;
import com.depromeet.buzz.comment.repository.CommentRepository;
import com.depromeet.buzz.user.domain.User;

@Service
@Transactional
public class CommentService {

	private final CommentRepository commentRepository;
	private final CommentLikeRepository commentLikeRepository;

	public CommentService(CommentRepository commentRepository,
		CommentLikeRepository commentLikeRepository) {
		this.commentRepository = commentRepository;
		this.commentLikeRepository = commentLikeRepository;
	}

	public boolean like(User user, Long commentId) {
		Optional<CommentLike> commentLike = commentLikeRepository.findByUserIdAndCommentId(user.getId(), commentId);
		if(commentLike.isPresent()) {
			return commentLikeRepository.deleteByUserIdAndCommentId(user.getId(), commentId) == 1;
		}

		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			return commentLikeRepository.save(new CommentLike(user, comment.get())) != null;
		}

		return false;
	}

}
