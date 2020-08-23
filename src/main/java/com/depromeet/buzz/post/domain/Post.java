package com.depromeet.buzz.post.domain;

import com.depromeet.buzz.category.domain.Category;
import com.depromeet.buzz.common.domain.BasicEntity;
import com.depromeet.buzz.discount.domain.Discount;
import com.depromeet.buzz.discount.domain.Step;
import static com.depromeet.buzz.discount.domain.Step.ZERO;
import com.depromeet.buzz.participation.domain.Participation;
import com.depromeet.buzz.user.domain.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
public class Post extends BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    private int price;

    private String preview;

    private String thumbnail;

    private String detailPage;

    private int goal;

    private LocalDateTime closingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Discount> discounts;

    @OneToMany(mappedBy = "post")
    private List<Participation> participations;

    @OneToMany(mappedBy = "post")
    private List<Wish> wishes;

    public Post() {
    }

    public Post(String productName, int price, String preview, String thumbnail, String detailPage
        , int goal, LocalDateTime closingDate, Category category, User user,
                List<Discount> discounts, List<Participation> participations) {
        this.productName = productName;
        this.price = price;
        this.preview = preview;
        this.thumbnail = thumbnail;
        this.detailPage = detailPage;
        this.goal = goal;
        this.closingDate = closingDate;
        this.category = category;
        this.user = user;
        this.discounts = discounts;
        this.participations = participations;
    }

    public int findDiscountRateByUserCount() {
        int userCount = participations.size();
        return findDiscountByUserCount(userCount)
            .map(Discount::getStep)
            .orElseGet(ZERO::getStep);
    }

    public Optional<Discount> findDiscountByUserCount(int userCount) {
        return discounts.stream()
            .filter(x -> x.isNotZeroStep(userCount))
            .max((x, y) -> ((Integer) x.getStep()).compareTo(y.getStep()));
    }

    public Discount getNextDiscount() {
        Optional<Discount> maybeDiscount = findDiscountByUserCount(participations.size());
        if (!maybeDiscount.isPresent()) {
            return discounts.stream().filter(discount -> discount.getStep() == 1).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("할인 정보 등록을 확인해주세요."));
        }
        Optional<Step> nextStep = Step.getNextStep(maybeDiscount.get().getStep());
        if (nextStep.isPresent()) {
            return discounts.stream().filter(discount -> discount.getStep() == nextStep.get().getStep()).findFirst()
                .orElse(null);
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getPreview() {
        return preview;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDetailPage() {
        return detailPage;
    }

    public int getGoal() {
        return goal;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public Category getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Post{" +
            "id=" + id +
            ", productName='" + productName + '\'' +
            ", price=" + price +
            ", thumbnail='" + thumbnail + '\'' +
            ", detailPage='" + detailPage + '\'' +
            ", goal=" + goal +
            ", closingDate=" + closingDate +
            '}';
    }
}
