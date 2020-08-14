package com.depromeet.buzz.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class PostDescriptionResponse {
    private Long id;
    private String title;
    private String category;
    private int price;
    private Discount nowDiscount;
    private Discount nextDiscount;
    private List<Discount> discounts;
    private int participants;
    private int numberOfGoal;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime deadline;

    private PostDescriptionResponse() {
    }

    public PostDescriptionResponse(Long id,
                                   String title,
                                   String category,
                                   int price,
                                   Discount nowDiscount,
                                   Discount nextDiscount,
                                   List<Discount> discounts,
                                   int participants,
                                   int numberOfGoal,
                                   LocalDateTime deadline) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.nowDiscount = nowDiscount;
        this.nextDiscount = nextDiscount;
        this.discounts = discounts;
        this.participants = participants;
        this.numberOfGoal = numberOfGoal;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
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

    public List<Discount> getDiscounts() {
        return discounts;
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

    public static PostDescriptionResponse mock() {
        return new PostDescriptionResponse(
            1L,
            "테이블팬 C820 (3 Colors)",
            "가전",
            50000,
            new Discount(1, 100, 35),
            new Discount(2, 200, 40),
            Arrays.asList(new Discount(1, 100, 35),
                new Discount(2, 200, 40),
                new Discount(3, 300, 50)),
            135,
            500,
            LocalDateTime.of(2020, Month.SEPTEMBER, 25, 23, 59, 59)
        );
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
