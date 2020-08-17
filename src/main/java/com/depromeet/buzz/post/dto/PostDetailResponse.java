package com.depromeet.buzz.post.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostDetailResponse {
    private Long postId;
    //맨위 배너 url
    private String BannerUrl;
    private PostDescriptionResponse description;
    private PostSellerResponse seller;
    private String contentUrl;
    private List<CommentResponse> comments;

    private PostDetailResponse() {
    }

    public PostDetailResponse(Long postId,
                              String bannerUrl,
                              PostDescriptionResponse description,
                              PostSellerResponse seller,
                              String contentUrl,
                              List<CommentResponse> comments) {
        this.postId = postId;
        this.BannerUrl = bannerUrl;
        this.description = description;
        this.seller = seller;
        this.contentUrl = contentUrl;
        this.comments = comments;
    }

    public static PostDetailResponse mock() {
        return new PostDetailResponse(1L,
                "https://fs.jtbc.joins.com/prog/img/mig/MOBILE/PR10010297.jpg",
                PostDescriptionResponse.mock(),
                PostSellerResponse.mock(),
                "https://files.slack.com/files-pri/T01753WJ8H1-F01916BREKE/image.png",
                Arrays.asList(
                        CommentResponse.mock(1L, 150, "첫번째 댓글 ", true, new ArrayList<>()),
                        CommentResponse.mock(2L, 120, "두번째 댓글 ", false, new ArrayList<>()),
                        CommentResponse.mock(3L, 100, "세번째 댓글 ", false, new ArrayList<>())
                ));
    }

    public Long getPostId() {
        return postId;
    }

    public String getBannerUrl() {
        return BannerUrl;
    }

    public PostDescriptionResponse getDescription() {
        return description;
    }

    public PostSellerResponse getSeller() {
        return seller;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public List<CommentResponse> getComments() {
        return comments;
    }

}
