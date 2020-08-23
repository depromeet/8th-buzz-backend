package com.depromeet.buzz.post.repository;

import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.dto.PostsRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {
    Page<Post> findPosts(PostsRequest request, Pageable pageable);
}
