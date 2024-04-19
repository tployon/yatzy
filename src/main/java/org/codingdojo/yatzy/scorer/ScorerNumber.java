package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.Scorer;
import org.codingdojo.yatzy.Yatzy;

public record ScorerNumber(int diceValue) implements Scorer {
    @Override
    public Integer score(Yatzy yatzy) {
        return yatzy.filterDiceValue(diceValue())
            .stream()
            .reduce(0, Integer::sum);
    }
}