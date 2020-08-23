package com.depromeet.buzz.post.dto;

import com.depromeet.buzz.user.domain.User;

import java.util.Random;

public class PostSellerResponse {
    private String sellerId;
    private String name;
    private String thumbnail;
    private int numberOfReview;

    private PostSellerResponse() {
    }

    public PostSellerResponse(String sellerId, String name, String thumbnail, int numberOfReview) {
        this.sellerId = sellerId;
        this.name = name;
        this.thumbnail = thumbnail;
        this.numberOfReview = numberOfReview;
    }

    public static PostSellerResponse mock() {
        return new PostSellerResponse(
            "1",
            "플러스마이너스제로",
            "",
            467
        );
    }

    public static PostSellerResponse from(User user) {
        return new PostSellerResponse(
            user.getUserId(),
            user.getName(),
            user.getThumbnail(),
            new Random().nextInt(1000)
        );
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getNumberOfReview() {
        return numberOfReview;
    }
}
