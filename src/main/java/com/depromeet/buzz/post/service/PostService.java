package com.depromeet.buzz.post.service;

import com.depromeet.buzz.participation.domain.Participation;
import com.depromeet.buzz.participation.repository.ParticipationRepository;
import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.domain.Wish;
import com.depromeet.buzz.post.dto.PostDescriptionResponse;
import com.depromeet.buzz.post.dto.PostSellerResponse;
import com.depromeet.buzz.post.repository.PostRepository;
import com.depromeet.buzz.post.repository.WishRepository;
import com.depromeet.buzz.user.domain.User;
import com.depromeet.buzz.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
@Transactional
public class PostService {
    private final UserService userService;
    private final ParticipationRepository participationRepository;
    private final PostRepository postRepository;
    private final WishRepository wishRepository;

    public PostService(UserService userService,
                       ParticipationRepository participationRepository,
                       PostRepository postRepository,
                       WishRepository wishRepository) {
        this.userService = userService;
        this.participationRepository = participationRepository;
        this.postRepository = postRepository;
        this.wishRepository = wishRepository;
    }

    public Post findById(Long postId) {
        return postRepository.findById(postId)
            .orElseThrow(() -> new NotFoundException(String.format("게시글을 찾을 수 없습니다. postId: %s", postId)));
    }

    public boolean like(User user, Long postId) {
        Optional<Wish> wishOptional = wishRepository.findByUserIdAndPostId(user.getId(), postId);
        if (wishOptional.isPresent()) {
            return wishRepository.deleteByUserIdAndPostId(user.getId(), postId) == 1;
        }

        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            return wishRepository.save(new Wish(user, post.get())) != null;
        }

        return false;
    }

    public void participate(String userId, Long postId) {
        if(participationRepository.existsByUserUserIdAndPostId(userId, postId)) {
            throw new IllegalArgumentException("이미 참여중입니다.");
        }
        User user = userService.findByUserId(userId);
        Post post = findById(postId);
        Participation participation = Participation.participate(user, post);
        participationRepository.save(participation);
    }

    public String getContent(Long postId) {
        Post post = findById(postId);
        return post.getDetailPage();
    }

    public PostSellerResponse getSeller(Long postId) {
        Post post = findById(postId);
        User user = post.getUser();
        return PostSellerResponse.from(user);
    }

    public PostDescriptionResponse getDescription(Long postId) {
        Post post = findById(postId);
        return PostDescriptionResponse.from(post);
    }

    public String getBanner(Long postId) {
        Post post = findById(postId);
        return post.getThumbnail();
    }
}
