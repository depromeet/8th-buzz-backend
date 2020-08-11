package com.depromeet.buzz.discount.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.depromeet.buzz.post.domain.Post;

@Entity
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	private Step step;

	private int interval;

	private int discountRate;

	private Discount() {

	}

	public Discount(Post post, Step step, int interval, int discountRate) {
		this.post = post;
		this.step = step;
		this.interval = interval;
		this.discountRate = discountRate;
	}

	public int getInterval() {
		return interval;
	}

	public int getStep() {
		return step.getStep();
	}

	public int getDiscountRate() {
		return discountRate;
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
			", post=" + post +
			", step=" + step +
			", interval=" + interval +
			", discountRate=" + discountRate +
			'}';
	}

	public int getStepByUserCount(int userCount) {
		if(this.getInterval() <= userCount) {
			return this.getStep();
		}

		return 0;
	}

}

