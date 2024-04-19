package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

public class YatzyScorer implements Scorer {
    public static final int YATZY = 50;

    public YatzyScorer() {
    }

    public Integer score(DiceRoll diceRoll) {
        return diceRoll.frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 5)
            .map(it -> YATZY)
            .findFirst()
            .orElse(Scorer.ZERO);
    }
}