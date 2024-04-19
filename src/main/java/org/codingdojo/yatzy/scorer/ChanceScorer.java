package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

public class ChanceScorer implements Scorer {
    public ChanceScorer() {
    }

    public Integer score(DiceRoll diceRoll) {
        return diceRoll.sum();
    }
}