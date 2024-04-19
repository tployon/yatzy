package org.codingdojo.yatzy1.scorer;

import org.codingdojo.yatzy1.Scorer;
import org.codingdojo.yatzy1.Yatzy;

public record ScorerNumber(int diceValue) implements Scorer {
    @Override
    public Integer score(Yatzy yatzy) {
        return yatzy.filterDiceValue(diceValue())
            .stream()
            .reduce(0, Integer::sum);
    }
}