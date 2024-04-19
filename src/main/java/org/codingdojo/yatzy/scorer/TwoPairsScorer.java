package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

import java.util.List;

public class TwoPairsScorer implements Scorer {
    public TwoPairsScorer() {
    }

    public Integer score(DiceRoll diceRoll) {
        List<Integer> pairs = diceRoll.atLeast(2);
        if (pairs.size() != 2)
            return Scorer.ZERO;

        return pairs
            .stream()
            .map(it -> it * 2)
            .reduce(0, Integer::sum);
    }
}