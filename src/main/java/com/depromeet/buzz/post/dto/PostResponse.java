package com.depromeet.buzz.post.dto;

import com.depromeet.buzz.post.domain.Post;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

public class PostResponse {
    private Long id;
    private String thumbnail;
    private int numberOfWish;
    private int numberOfComment;
    private String title;
    private String category;
    private String sellerName;
    private int price;
    private Discount nowDiscount;
    private Discount nextDiscount;
    private int participants;
    private int numberOfGoal;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime deadline;

    private PostResponse() {
    }

    public PostResponse(Long id,
                        String thumbnail,
                        int numberOfWish,
                        int numberOfComment,
                        String title,
                        String category,
                        String sellerName,
                        int price,
                        Discount nowDiscount,
                        Discount nextDiscount,
                        int participants,
                        int numberOfGoal,
                        LocalDateTime deadline) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.numberOfWish = numberOfWish;
        this.numberOfComment = numberOfComment;
        this.title = title;
        this.category = category;
        this.sellerName = sellerName;
        this.price = price;
        this.nowDiscount = nowDiscount;
        this.nextDiscount = nextDiscount;
        this.participants = participants;
        this.numberOfGoal = numberOfGoal;
        this.deadline = deadline;
    }


    public static PostResponse of(Post post, Map<Long, Integer> numberOfCommentByPostIds) {
        com.depromeet.buzz.discount.domain.Discount nowDiscount =
            post.findDiscountByUserCount(post.getParticipations().size())
                .orElse(null);
        com.depromeet.buzz.discount.domain.Discount nextDiscount = post.getNextDiscount();
        return new PostResponse(
            post.getId(),
            post.getPreview(),
            post.getWishes().size(),
            numberOfCommentByPostIds.get(post.getId()),
            post.getProductName(),
            post.getCategory().getName(),
            post.getUser().getName(),
            post.getPrice(),
            Discount.from(nowDiscount),
            Discount.from(nextDiscount),
            post.getParticipations().size(),
            post.getGoal(),
            post.getClosingDate()
        );
    }

    public static PostResponse mock() {
        return new PostResponse(
            1L,
            "https://fs.jtbc.joins.com/prog/img/mig/MOBILE/PR10010297.jpg",
            100,
            200,
            "예이이",
            "전자",
            "곽은담",
            50000,
            new Discount(1, 100, 35),
            new Discount(2, 200, 40),
            130,
            300,
            LocalDateTime.of(2020, Month.SEPTEMBER, 10, 23, 59, 59)
        );
    }

    public Long getId() {
        return id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public int getNumberOfWish() {
        return numberOfWish;
    }

    public int getNumberOfComment() {
        return numberOfComment;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getSellerName() {
        return sellerName;
    }

    public int getPrice() {
        return price;
    }

    public Discount getNowDiscount() {
        return nowDiscount;
    }

    public Discount getNextDiscount() {
        return nextDiscount;
    }

    public int getParticipants() {
        return participants;
    }

    public int getNumberOfGoal() {
        return numberOfGoal;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    private static class Discount {
        private int step;
        private int numberOfPeople;
        private int discountPercent;

        private Discount() {
        }

        public Discount(int step, int numberOfPeople, int discountPercent) {
            this.step = step;
            this.numberOfPeople = numberOfPeople;
            this.discountPercent = discountPercent;
        }
        public static Discount from(com.depromeet.buzz.discount.domain.Discount discount) {
            if (discount == null) {
                return null;
            }

            return new Discount(
                discount.getStep(),
                discount.getMinRequire(),
                discount.getDiscountRate()
            );
        }

        private static Discount none() {
            return new Discount(
                99999,
                99999,
                99999
            );
        }

        public int getStep() {
            return step;
        }

        public int getNumberOfPeople() {
            return numberOfPeople;
        }

        public int getDiscountPercent() {
            return discountPercent;
        }
    }

}
