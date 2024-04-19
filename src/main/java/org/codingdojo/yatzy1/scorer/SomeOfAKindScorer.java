package org.codingdojo.yatzy1.scorer;

import org.codingdojo.yatzy1.Scorer;
import org.codingdojo.yatzy1.Yatzy;

public record SomeOfAKindScorer(int atLeastFrequency) implements Scorer {
    public Integer score(Yatzy yatzy) {
        return yatzy.atLeast(atLeastFrequency())
            .stream()
            .findFirst()
            .map(it -> it * atLeastFrequency())
            .orElse(Yatzy.ZERO);
    }
}