package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

public record SomeOfAKindScorer(int atLeastFrequency) implements Scorer {
    public Integer score(DiceRoll diceRoll) {
        return diceRoll.atLeast(atLeastFrequency())
            .stream()
            .findFirst()
            .map(it -> it * atLeastFrequency())
            .orElse(Scorer.ZERO);
    }
}