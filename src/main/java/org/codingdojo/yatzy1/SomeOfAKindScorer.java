package org.codingdojo.yatzy1;

public record SomeOfAKindScorer(int atLeastFrequency) implements Scorer {
    public Integer score(Yatzy yatzy) {
        return yatzy.atLeast(atLeastFrequency())
            .stream()
            .findFirst()
            .map(it -> it * atLeastFrequency())
            .orElse(Yatzy.ZERO);
    }
}