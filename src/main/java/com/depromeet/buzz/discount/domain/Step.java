package com.depromeet.buzz.discount.domain;

public enum Step {
	ZERO(0),
	FIRST(1),
	SECOND(2),
	THIRD(3);

	private int step;

	public static final Discount NOT_DISCOUNT = null;

	private Step(int step) {
		this.step = step;
	}

	public int getStep() {
		return step;
	}

}
