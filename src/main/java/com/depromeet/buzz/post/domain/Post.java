package com.depromeet.buzz.post.domain;

import static com.depromeet.buzz.discount.domain.Step.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.depromeet.buzz.category.domain.Category;
import com.depromeet.buzz.common.domain.BasicEntity;
import com.depromeet.buzz.discount.domain.Discount;
import com.depromeet.buzz.participation.domain.Participation;
import com.depromeet.buzz.user.domain.User;

@Entity
public class Post extends BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String productName;

	private int price;

	private String thumbnail;

	private String detailPage;

	private Date regDate;

	private Date closingDate;

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

	private Post() {}

	public Post(String productName, int price, String thumbnail, String detailPage
		, Date regDate, Date closingDate, Category category, User user,
		List<Discount> discounts, List<Participation> participations) {
		this.productName = productName;
		this.price = price;
		this.thumbnail = thumbnail;
		this.detailPage = detailPage;
		this.regDate = regDate;
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
			.max((x, y) -> ((Integer)x.getStep()).compareTo(y.getStep()));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Post post = (Post)o;
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
			", regDate=" + regDate +
			", closingDate=" + closingDate +
			", category=" + category +
			", user=" + user +
			", discounts=" + discounts +
			", participations=" + participations +
			'}';
	}

}
