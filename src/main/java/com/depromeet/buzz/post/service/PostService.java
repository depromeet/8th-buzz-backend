package com.depromeet.buzz.post.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.domain.Wish;
import com.depromeet.buzz.post.repository.PostRepository;
import com.depromeet.buzz.post.repository.WishRepository;
import com.depromeet.buzz.user.domain.User;

@Service
public class PostService {

	private PostRepository postRepository;
	private WishRepository wishRepository;

	public PostService(PostRepository postRepository, WishRepository wishRepository) {
		this.postRepository = postRepository;
		this.wishRepository = wishRepository;
	}

	public void like(User user, Long postId) throws NoSuchElementException {
		wishRepository.findByUserIdAndPostId(user.getId(), postId).ifPresent(w -> {
				wishRepository.deleteByUserIdAndPostId(user.getId(), postId);
				return;
		});

		Post post = postRepository.findById(postId)
			.orElseThrow(() -> new NoSuchElementException("상품이 존재하지 않습니다."));
		wishRepository.save(new Wish(user, post));
	}

}
