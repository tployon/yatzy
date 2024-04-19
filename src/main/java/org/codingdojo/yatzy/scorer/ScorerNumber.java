package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

public record ScorerNumber(int diceValue) implements Scorer {
    @Override
    public Integer score(DiceRoll diceRoll) {
        return diceRoll.filterDiceValue(diceValue())
            .stream()
            .reduce(0, Integer::sum);
    }
}