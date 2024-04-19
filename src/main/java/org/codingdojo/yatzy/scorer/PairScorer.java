package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.Scorer;
import org.codingdojo.yatzy.Yatzy;

import java.util.Comparator;

public class PairScorer implements Scorer {
    public PairScorer() {
    }

    public Integer score(Yatzy yatzy) {
        return yatzy
            .atLeast(2)
            .stream()
            .max(Comparator.naturalOrder())
            .map(it -> it * 2)
            .orElse(Scorer.ZERO);
    }
}