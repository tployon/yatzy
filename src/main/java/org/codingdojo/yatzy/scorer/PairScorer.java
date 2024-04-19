package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

import java.util.Comparator;

public class PairScorer implements Scorer {
    public PairScorer() {
    }

    public Integer score(DiceRoll diceRoll) {
        return diceRoll
            .atLeast(2)
            .stream()
            .max(Comparator.naturalOrder())
            .map(it -> it * 2)
            .orElse(Scorer.ZERO);
    }
}