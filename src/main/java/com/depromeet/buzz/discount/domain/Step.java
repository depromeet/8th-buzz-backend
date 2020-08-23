package com.depromeet.buzz.discount.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Step {
    ZERO(0),
    FIRST(1),
    SECOND(2),
    THIRD(3);

    private int step;

    private Step(int step) {
        this.step = step;
    }

    public static Optional<Step> getNextStep(int nowStep) {
        return Arrays.stream(values())
            .filter(step -> step.step == nowStep + 1)
            .findFirst();
    }

    public int getStep() {
        return step;
    }

}
