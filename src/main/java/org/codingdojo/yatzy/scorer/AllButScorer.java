package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.Scorer;
import org.codingdojo.yatzy.DiceRoll;

import java.util.Objects;

public record AllButScorer(int notAllowedDiceValue) implements Scorer {

    @Override
    public Integer score(DiceRoll yatzy) {
        long count = yatzy.frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 1)
            .filter(it -> !Objects.equals(it.getKey(), notAllowedDiceValue()))
            .count();
        if (count != 5)
            return Scorer.ZERO;
        return yatzy.sum();
    }
}