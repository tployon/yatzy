package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

import java.util.Map;

public class FullHouseScorer implements Scorer {

    public FullHouseScorer() {
    }

    public Integer score(DiceRoll diceRoll) {
        Map<Integer, Long> frequencies = diceRoll.frequencies();
        if (frequencies.size() != 2 || !frequencies.containsValue(3L))
            return Scorer.ZERO;
        return diceRoll.sum();
    }
}