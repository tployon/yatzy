package org.codingdojo.yatzy1.scorer;

import org.codingdojo.yatzy1.Scorer;
import org.codingdojo.yatzy1.Yatzy;

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
            .orElse(Yatzy.ZERO);
    }
}