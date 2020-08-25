package com.depromeet.buzz.post.controller;

import com.depromeet.buzz.comment.service.CommentService;
import com.depromeet.buzz.post.dto.CommentResponse;
import com.depromeet.buzz.post.dto.PostDescriptionResponse;
import com.depromeet.buzz.post.dto.PostDetailResponse;
import com.depromeet.buzz.post.dto.PostResponse;
import com.depromeet.buzz.post.dto.PostSellerResponse;
import com.depromeet.buzz.post.dto.PostsRequest;
import com.depromeet.buzz.post.service.PostService;
import com.depromeet.buzz.user.domain.User;
import com.depromeet.buzz.user.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    public PostController(PostService postService, UserService userService, CommentService commentService) {
        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @GetMapping
    @ApiResponse(description = "게시글의 옵션에 따른 정보를 가져온다(페이징)")
    @Parameters(value = {
        @Parameter(name = "category", description = "카테고리 정보", in = ParameterIn.QUERY),
        @Parameter(name = "page", description = "현재 페이지 정보 기본은 0", in = ParameterIn.QUERY),
        @Parameter(name = "size", description = "원하는 컨텐츠 수 기본은 10", in = ParameterIn.QUERY),
        @Parameter(name = "sortOption", description = "정렬 기준", in = ParameterIn.QUERY)
    })
    public ResponseEntity<Page<PostResponse>> get(PostsRequest request, @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(postService.findPosts(request, pageable));
    }

    @GetMapping("{postId}")
    @ApiResponse(description = "상세 게시글 정보(한번에)")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<PostDetailResponse> getPostDetail(@RequestHeader("User-ID") String userId, @PathVariable Long postId) {
        User user = userService.findByUserId(userId);
        List<CommentResponse> comments = commentService.findPopularCommentsByPostId(postId, user);
        return ResponseEntity.ok(postService.getDetailPost(user, comments, postId));
    }

    @GetMapping("{postId}/banner")
    @ApiResponse(description = "상세 게시글 이미지 URL(배너)")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<String> getPostBanner(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getBanner(postId));
    }

    @GetMapping("{postId}/description")
    @ApiResponse(description = "제품명 및 할인률, 가격")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<PostDescriptionResponse> getPostDescription(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getDescription(postId));
    }

    @GetMapping("{postId}/seller")
    @ApiResponse(description = "주최자 정보")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<PostSellerResponse> getSeller(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getSeller(postId));
    }


    @GetMapping("{postId}/content")
    @ApiResponse(description = "상세 게시글 설명")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<String> getContent(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getContent(postId));
    }


    @GetMapping("{postId}/comments")
    @ApiResponse(description = "제품에 대한 댓글리스트 가져옴")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<List<CommentResponse>> getComments(@RequestHeader("User-ID") String userId, @PathVariable Long postId) {
        User user = userService.findByUserId(userId);
        return ResponseEntity.ok(commentService.findPopularCommentsByPostId(postId, user));
    }

    @GetMapping("{postId}/comments/detail")
    @ApiResponse(description = "제품에 대한 상세 댓글리스트 불러옴(페이징)")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH),
        @Parameter(name = "page", description = "현재 페이지 정보 기본은 0", in = ParameterIn.QUERY),
        @Parameter(name = "size", description = "원하는 컨텐츠 수 기본은 10", in = ParameterIn.QUERY),
    })
    public ResponseEntity<Page<CommentResponse>> getCommentsDetail(@RequestHeader("User-ID") String userId, @PathVariable Long postId, Pageable pageable) {
        User user = userService.findByUserId(userId);
        return ResponseEntity.ok(commentService.findCommentsByPostId(postId, pageable, user));
    }

    @PostMapping("{postId}/like")
    @ApiResponse(description = "제품에 대한 좋아요 토글")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<Boolean> like(@RequestHeader("User-ID") String userId, @PathVariable Long postId) {
        User user = userService.findByUserId(userId);

        return ResponseEntity.ok(postService.like(user, postId));
    }

    @PostMapping("{postId}/participate")
    @ApiResponse(description = "제품 참여")
    @Parameters(value = {
        @Parameter(name = "postId", description = "게시글 id", in = ParameterIn.PATH)
    })
    public ResponseEntity<Boolean> participate(@RequestHeader("User-ID") String userId, @PathVariable Long postId) {
        return ResponseEntity.ok(postService.participate(userId, postId));
    }

}
