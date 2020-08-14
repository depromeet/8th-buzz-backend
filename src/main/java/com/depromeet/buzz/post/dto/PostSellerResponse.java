package com.depromeet.buzz.post.dto;

public class PostSellerResponse {
    private Long sellerId;
    private String name;
    private int numberOfReview;

    private PostSellerResponse() {
    }

    public PostSellerResponse(Long sellerId, String name, int numberOfReview) {
        this.sellerId = sellerId;
        this.name = name;
        this.numberOfReview = numberOfReview;
    }

    public static PostSellerResponse mock() {
        return new PostSellerResponse(
            1L,
            "플러스마이너스제로",
            467
        );
    }

    public Long getSellerId() {
        return sellerId;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfReview() {
        return numberOfReview;
    }
}
