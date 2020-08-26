package com.depromeet.buzz.common.service;

import com.depromeet.buzz.comment.domain.Comment;
import com.depromeet.buzz.comment.domain.CommentLike;
import com.depromeet.buzz.comment.repository.CommentLikeRepository;
import com.depromeet.buzz.comment.repository.CommentRepository;
import com.depromeet.buzz.participation.domain.Participation;
import com.depromeet.buzz.participation.repository.ParticipationRepository;
import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.domain.Wish;
import com.depromeet.buzz.post.repository.PostRepository;
import com.depromeet.buzz.post.repository.WishRepository;
import com.depromeet.buzz.user.domain.User;
import com.depromeet.buzz.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class InitService {
    private static final Map<Long, Integer> WISH_DATA;
    private static final Map<Long, Integer> PARTICIPATE_DATA;
    private static final Map<Long, Integer> COMMENT_LIKE;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final WishRepository wishRepository;
    private final ParticipationRepository participationRepository;
    private final CommentRepository commentRepository;
    private final CommentLikeRepository commentLikeRepository;

    public InitService(UserRepository userRepository,
                       PostRepository postRepository,
                       WishRepository wishRepository,
                       ParticipationRepository participationRepository,
                       CommentRepository commentRepository,
                       CommentLikeRepository commentLikeRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.wishRepository = wishRepository;
        this.participationRepository = participationRepository;
        this.commentRepository = commentRepository;
        this.commentLikeRepository = commentLikeRepository;
    }

    public void init() {
        PARTICIPATE_DATA.forEach((key, value) -> {
            Post post = postRepository.findById(key).get();
            Page<User> users = userRepository.findByIdAfter(200L, PageRequest.of(0, value));
            List<Participation> participations = users.getContent().stream()
                    .map(user -> Participation.participate(user, post))
                    .collect(Collectors.toList());
            participationRepository.saveAll(participations);
        });

        WISH_DATA.forEach((key, value) -> {
            Post post = postRepository.findById(key).get();
            Page<User> users = userRepository.findByIdAfter(200L, PageRequest.of(0, value));
            List<Wish> wishes = users.getContent().stream()
                    .map(user -> new Wish(user, post))
                    .collect(Collectors.toList());
            wishRepository.saveAll(wishes);
        });

        COMMENT_LIKE.forEach((key, value) -> {
            Comment comment = commentRepository.findById(key).get();
            Page<User> users = userRepository.findByIdAfter(200L, PageRequest.of(0, value));
            List<CommentLike> commentLikes = users.getContent().stream()
                    .map(user -> new CommentLike(user, comment))
                    .collect(Collectors.toList());
            commentLikeRepository.saveAll(commentLikes);
        });
    }

    static {
        PARTICIPATE_DATA = new HashMap<>();
        PARTICIPATE_DATA.put(1L, 537);
        PARTICIPATE_DATA.put(2L, 136);
        PARTICIPATE_DATA.put(3L, 125);
        PARTICIPATE_DATA.put(4L, 376);
        PARTICIPATE_DATA.put(5L, 408);
        PARTICIPATE_DATA.put(6L, 382);
        PARTICIPATE_DATA.put(7L, 198);
        PARTICIPATE_DATA.put(8L, 294);
        PARTICIPATE_DATA.put(9L, 86);
        PARTICIPATE_DATA.put(10L, 359);
        PARTICIPATE_DATA.put(11L, 96);
        PARTICIPATE_DATA.put(12L, 492);
        PARTICIPATE_DATA.put(13L, 240);
        PARTICIPATE_DATA.put(14L, 452);
        PARTICIPATE_DATA.put(15L, 140);
        PARTICIPATE_DATA.put(16L, 325);
        PARTICIPATE_DATA.put(17L, 96);
        PARTICIPATE_DATA.put(18L, 252);
        PARTICIPATE_DATA.put(19L, 142);
        PARTICIPATE_DATA.put(20L, 120);
        PARTICIPATE_DATA.put(21L, 197);
        PARTICIPATE_DATA.put(22L, 122);
        PARTICIPATE_DATA.put(23L, 322);
        PARTICIPATE_DATA.put(24L, 148);
        PARTICIPATE_DATA.put(25L, 17);
        PARTICIPATE_DATA.put(26L, 215);
        PARTICIPATE_DATA.put(27L, 352);
        PARTICIPATE_DATA.put(28L, 319);
        PARTICIPATE_DATA.put(29L, 421);
        PARTICIPATE_DATA.put(30L, 152);
        PARTICIPATE_DATA.put(31L, 187);
        PARTICIPATE_DATA.put(32L, 152);
        PARTICIPATE_DATA.put(33L, 221);
        PARTICIPATE_DATA.put(34L, 152);
        PARTICIPATE_DATA.put(35L, 48);
        PARTICIPATE_DATA.put(36L, 186);
        PARTICIPATE_DATA.put(37L, 294);
        PARTICIPATE_DATA.put(38L, 136);
        PARTICIPATE_DATA.put(39L, 423);
        PARTICIPATE_DATA.put(40L, 36);
        PARTICIPATE_DATA.put(41L, 89);
        PARTICIPATE_DATA.put(42L, 786);

        WISH_DATA = new HashMap<>();
        WISH_DATA.put(1L, 412);
        WISH_DATA.put(12L, 350);
        WISH_DATA.put(14L, 574);
        WISH_DATA.put(23L, 216);
        WISH_DATA.put(29L, 671);

        COMMENT_LIKE = new HashMap<>();
        COMMENT_LIKE.put(1L, 14);
        COMMENT_LIKE.put(6L, 8);
        COMMENT_LIKE.put(9L, 3);
        COMMENT_LIKE.put(10L, 2);
        COMMENT_LIKE.put(13L, 7);
    }
}
