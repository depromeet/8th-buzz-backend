package com.depromeet.buzz.comment.controller;

import com.depromeet.buzz.comment.dto.CommentCreateRequest;
import com.depromeet.buzz.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @ApiResponse(description = "댓글 생성")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id"),
        @Parameter(name = "commentId", description = "댓글 id 대댓글인 경우 필수"),
        @Parameter(name = "userId", description = "유저 id"),
        @Parameter(name = "content", description = "댓글 내용")
    })
    public ResponseEntity<Void> create(@RequestBody CommentCreateRequest request) {
        commentService.create(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    @ApiResponse(description = "댓글 삭제")
    @Parameters(value = {
        @Parameter(name = "commentId", description = "댓글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<Void> delete(@PathVariable Long commentId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("{commentId}/like")
    @ApiResponse(description = "댓글 대한 좋아요 토글")
    @Parameters(value = {
        @Parameter(name = "commentId", description = "댓글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<Boolean> like(@PathVariable Long commentId) {
        return ResponseEntity.ok(true);
    }
}

