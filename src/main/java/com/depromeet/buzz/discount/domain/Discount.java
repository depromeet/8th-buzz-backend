package com.depromeet.buzz.discount.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.depromeet.buzz.common.domain.BasicEntity;
import com.depromeet.buzz.post.domain.Post;

@Entity
public class Discount extends BasicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	@Enumerated(value = EnumType.STRING)
	private Step step;

	private int minRequire;

	private int discountRate;

	public Discount() {

	}

	public Discount(Post post, Step step, int interval, int discountRate) {
		this.post = post;
		this.step = step;
		this.minRequire = interval;
		this.discountRate = discountRate;
	}

	public int getMinRequire() {
		return minRequire;
	}

	public int getStep() {
		return step.getStep();
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public boolean isNotZeroStep(int userCount) {
		if(this.getMinRequire() <= userCount) {
			return true;
		}

		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Discount discount = (Discount)o;
		return Objects.equals(id, discount.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Discount{" +
			"id=" + id +
			", step=" + step +
			", minRequire=" + minRequire +
			", discountRate=" + discountRate +
			'}';
	}
}