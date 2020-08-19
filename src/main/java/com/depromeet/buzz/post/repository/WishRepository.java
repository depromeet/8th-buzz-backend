package com.depromeet.buzz.post.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.buzz.post.domain.Wish;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {

	public Optional<Wish> findByUserIdAndPostId(Long userId, Long postId);

	public int deleteByUserIdAndPostId(Long userId, Long postId);

}
