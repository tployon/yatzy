package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

import java.util.Objects;

public record AllButScorer(int notAllowedDiceValue) implements Scorer {

    @Override
    public Integer score(DiceRoll diceRoll) {
        long count = diceRoll.frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 1)
            .filter(it -> !Objects.equals(it.getKey(), notAllowedDiceValue()))
            .count();
        if (count != 5)
            return Scorer.ZERO;
        return diceRoll.sum();
    }
}