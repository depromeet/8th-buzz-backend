package com.depromeet.buzz.post.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.domain.Wish;
import com.depromeet.buzz.post.repository.PostRepository;
import com.depromeet.buzz.post.repository.WishRepository;
import com.depromeet.buzz.user.domain.User;

@Service
@Transactional
public class PostService {

	private final PostRepository postRepository;
	private final WishRepository wishRepository;

	public PostService(PostRepository postRepository, WishRepository wishRepository) {
		this.postRepository = postRepository;
		this.wishRepository = wishRepository;
	}

	public boolean like(User user, Long postId) {
		Optional<Wish> wishOptional = wishRepository.findByUserIdAndPostId(user.getId(), postId);
		if(wishOptional.isPresent()) {
			return wishRepository.deleteByUserIdAndPostId(user.getId(), postId) == 1;
		}

		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			return wishRepository.save(new Wish(user, post.get())) != null;
		}

		return false;
	}

}
