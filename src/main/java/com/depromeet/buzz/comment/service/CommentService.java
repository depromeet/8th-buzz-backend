package com.depromeet.buzz.comment.service;

import com.depromeet.buzz.comment.domain.Comment;
import com.depromeet.buzz.comment.dto.CommentCreateRequest;
import com.depromeet.buzz.comment.repository.CommentRepository;
import com.depromeet.buzz.post.domain.Post;
import com.depromeet.buzz.post.service.PostService;
import com.depromeet.buzz.user.domain.User;
import com.depromeet.buzz.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.Objects;

@Service
@Transactional
public class CommentService {
    private final UserService userService;
    private final PostService postService;
    private final CommentRepository commentRepository;

    public CommentService(UserService userService, PostService postService, CommentRepository commentRepository) {
        this.userService = userService;
        this.postService = postService;
        this.commentRepository = commentRepository;
    }


    public void create(CommentCreateRequest request) {
        User user = userService.findByUserId(request.getUserId());
        Post post = postService.findById(request.getPostId());
        Comment comment = new Comment(request.getContent(), user, post);
        //대댓글이 아닌 경우
        if (Objects.nonNull(request.getCommentId())) {
            Long parentCommentId = request.getCommentId();
            Comment parentComment = commentRepository.findById(parentCommentId)
                    .orElseThrow(() -> new NotFoundException(String.format("부모가 존재하지 않습니다. commentId : %s", parentCommentId)));
            comment.addParent(parentComment);
        }

        commentRepository.save(comment);
    }
}
