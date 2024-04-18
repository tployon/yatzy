package org.codingdojo.yatzy1;

public record ScorerNumber(int diceValue) implements Scorer {
    @Override
    public Integer score(Yatzy yatzy) {
        return yatzy.filterDiceValue(diceValue())
            .stream()
            .reduce(0, Integer::sum);
    }
}