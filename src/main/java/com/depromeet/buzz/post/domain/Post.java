package com.depromeet.buzz.post.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.depromeet.buzz.category.domain.Category;
import com.depromeet.buzz.user.domain.User;

@Entity
public class Post {

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

	private Post() { }

	public Post(String productName, int price, String thumbnail,
		String detailPage, Date regDate, Date closingDate) {
		this.productName = productName;
		this.price = price;
		this.thumbnail = thumbnail;
		this.detailPage = detailPage;
		this.regDate = regDate;
		this.closingDate = closingDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Post post = (Post)o;
		return id.equals(post.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, productName, price, thumbnail,
			detailPage, regDate, closingDate, category, user);
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
			'}';
	}

}
