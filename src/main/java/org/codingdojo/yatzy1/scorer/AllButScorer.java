package org.codingdojo.yatzy1.scorer;

import org.codingdojo.yatzy1.Scorer;
import org.codingdojo.yatzy1.Yatzy;

import java.util.Objects;

public record AllButScorer(int notAllowedDiceValue) implements Scorer {

    @Override
    public Integer score(Yatzy yatzy) {
        long count = yatzy.frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 1)
            .filter(it -> !Objects.equals(it.getKey(), notAllowedDiceValue()))
            .count();
        if (count != 5)
            return Yatzy.ZERO;
        return yatzy.sum();
    }
}