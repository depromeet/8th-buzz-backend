package com.depromeet.buzz.discount.domain;

import static org.junit.jupiter.api.Assertions.*;

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
		// 인원수 미달로 결과가 Step.ZERO
		assertAll(
			() -> assertEquals(Step.ZERO.getStep(), discount1.getStepByUserCount(0)),
			() -> assertEquals(Step.ZERO.getStep(), discount2.getStepByUserCount(2)),
			() -> assertEquals(Step.ZERO.getStep(), discount3.getStepByUserCount(4))
		);

		// 할인되는 인원수 달성
		assertAll(
			() -> assertEquals(Step.FIRST.getStep(), discount1.getStepByUserCount(1)),
			() -> assertEquals(Step.SECOND.getStep(), discount2.getStepByUserCount(3)),
			() -> assertEquals(Step.THIRD.getStep(), discount3.getStepByUserCount(5))
		);
	}

}