package com.depromeet.buzz.discount.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountTest {

	private static Discount discount1;
	private static Discount discount2;
	private static Discount discount3;

	@BeforeAll
	static void setup() {
		discount1 = new Discount(null, Step.FIRST, 1, 10);
		discount2 = new Discount(null, Step.SECOND, 3, 15);
		discount3 = new Discount(null, Step.THIRD, 5, 20);
	}

	@Test
	@DisplayName("할인되는 목표 인원수에 도달했는지")
	void getStepByUserCount() {
		// 인원수 미달
		assertThat(discount1.isNotZeroStep(0), is(equalTo( false)));
		assertThat(discount2.isNotZeroStep(2), is(equalTo( false)));
		assertThat(discount3.isNotZeroStep(4), is(equalTo( false)));

		// 할인되는 인원수 달성
		assertThat(discount1.isNotZeroStep(1), is(equalTo( true)));
		assertThat(discount2.isNotZeroStep(3), is(equalTo( true)));
		assertThat(discount3.isNotZeroStep(5), is(equalTo( true)));
	}

}