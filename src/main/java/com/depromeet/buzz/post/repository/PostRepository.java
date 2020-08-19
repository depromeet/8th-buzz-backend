package com.depromeet.buzz.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.buzz.post.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
