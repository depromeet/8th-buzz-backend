package com.depromeet.buzz.comment.controller;

import com.depromeet.buzz.comment.dto.CommentCreateRequest;
import com.depromeet.buzz.comment.service.CommentService;
import com.depromeet.buzz.post.dto.CommentResponse;
import com.depromeet.buzz.user.domain.User;
import com.depromeet.buzz.user.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final UserService userService;
    private final CommentService commentService;

    public CommentController(UserService userService, CommentService commentService) {
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping("/{commentId}")
    @ApiResponse(description = "특정 댓글 + 대댓글 정보 싹다")
    @Parameters(value = {
        @Parameter(name = "commentId", description = "상위 댓글 아이디")
    })
    public ResponseEntity<List<CommentResponse>> getComment(@PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.findCommentWithSub(commentId));
    }

    @PostMapping
    @ApiResponse(description = "댓글 생성")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id"),
        @Parameter(name = "commentId", description = "댓글 id 대댓글인 경우 필수"),
        @Parameter(name = "userId", description = "유저 id"),
        @Parameter(name = "content", description = "댓글 내용")
    })
    public ResponseEntity<CommentResponse> create(@RequestBody CommentCreateRequest request) {
        return ResponseEntity.ok(commentService.create(request));
    }

    @DeleteMapping("/{commentId}")
    @ApiResponse(description = "댓글 삭제")
    @Parameters(value = {
        @Parameter(name = "commentId", description = "댓글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<Boolean> delete(@RequestHeader("User-ID") String userId, @PathVariable Long commentId) {
        return ResponseEntity.ok(commentService.delete(userId, commentId));
    }

    @PostMapping("{commentId}/like")
    @ApiResponse(description = "댓글 대한 좋아요 토글")
    @Parameters(value = {
        @Parameter(name = "commentId", description = "댓글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<Boolean> like(@RequestHeader("User-ID") String userId, @PathVariable Long commentId) {
        User user = userService.findByUserId(userId);

        if (commentService.like(user, commentId)) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

}

