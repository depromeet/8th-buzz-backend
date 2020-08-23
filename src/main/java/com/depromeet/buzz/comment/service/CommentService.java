package com.depromeet.buzz.comment.service;

import com.depromeet.buzz.comment.domain.Comment;
import com.depromeet.buzz.comment.domain.CommentLike;
import com.depromeet.buzz.comment.dto.CommentCreateRequest;
import com.depromeet.buzz.comment.repository.CommentLikeRepository;
import com.depromeet.buzz.comment.repository.CommentRepository;
import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.dto.CommentResponse;
import com.depromeet.buzz.post.service.PostService;
import com.depromeet.buzz.user.domain.User;
import com.depromeet.buzz.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentService {

    private final UserService userService;
    private final PostService postService;
    private final CommentRepository commentRepository;
    private final CommentLikeRepository commentLikeRepository;

    public CommentService(UserService userService, PostService postService,
                          CommentRepository commentRepository, CommentLikeRepository commentLikeRepository) {
        this.userService = userService;
        this.postService = postService;
        this.commentRepository = commentRepository;
        this.commentLikeRepository = commentLikeRepository;
    }

    private Comment findById(Long commentId) {
        return commentRepository.findById(commentId)
            .orElseThrow(() -> new NotFoundException(String.format("댓글이 존재하지 않습니다. commentId : %s", commentId)));
    }

    public CommentResponse create(CommentCreateRequest request) {
        User user = userService.findByUserId(request.getUserId());
        Post post = postService.findById(request.getPostId());
        Comment comment = new Comment(request.getContent(), user, post);
        //대댓글이 아닌 경우
        if (Objects.nonNull(request.getCommentId())) {
            Long parentCommentId = request.getCommentId();
            Comment parentComment = findById(parentCommentId);
            comment.addParent(parentComment);
        }

        return CommentResponse.from(commentRepository.save(comment));
    }

    public void delete(String userId, Long commentId) {
        User user = userService.findByUserId(userId);
        Comment comment = findById(commentId);

        if (!comment.isEnableDelete(user)) {
            throw new IllegalArgumentException("해당 유저는 해당 댓글을 삭제할 수 없습니다.");
        }
        commentRepository.delete(comment);
    }

    public boolean like(User user, Long commentId) {
        Optional<CommentLike> commentLike = commentLikeRepository.findByUserIdAndCommentId(user.getId(), commentId);
        if (commentLike.isPresent()) {
            commentLikeRepository.delete(commentLike.get());
            return false;
        }

        Comment comment = findById(commentId);

        commentLikeRepository.save(new CommentLike(user, comment));
        return true;
    }

    public Page<CommentResponse> findCommentsByPostId(Long postId, Pageable pageable) {
        Page<Comment> comments = commentRepository.findCommentsByPostId(postId, pageable);
        List<CommentResponse> commentResponses = comments.getContent().stream()
            .map(CommentResponse::getPreviewComment)
            .collect(Collectors.toList());

        return new PageImpl<>(commentResponses, pageable, comments.getTotalElements());
    }

    public List<CommentResponse> findCommentWithSub(Long commentId) {
        Comment comment = findById(commentId);

        if (comment.hasParent()) {
            return new ArrayList<>();
        }

        return comment.getSubComments().stream()
            .map(CommentResponse::from)
            .collect(Collectors.toList());
    }

    public List<CommentResponse> findPopularCommentsByPostId(Long postId) {
        List<Comment> comments = new ArrayList<>();
        Map<Comment, Integer> commentsLikeCnt = commentRepository.findPopularCommentsByPostId(postId);

        List<Comment> keySetList = new ArrayList<>(commentsLikeCnt.keySet());
        Collections.sort(keySetList, (o1, o2) -> (commentsLikeCnt.get(o2).compareTo(commentsLikeCnt.get(o1))));
        keySetList.stream().limit(3).forEach(k -> comments.add(k));

        return comments.stream()
            .map(CommentResponse::from)
            .collect(Collectors.toList());
    }

}
