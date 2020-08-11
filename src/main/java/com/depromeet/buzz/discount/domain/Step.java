package com.depromeet.buzz.discount.domain;

public enum Step {
	FIRST(1),
	SECOND(2),
	THIRD(3);

	private int step;

	private Step(int step) {
		this.step = step;
	}

	public int getStep() {
		return step;
	}

}
