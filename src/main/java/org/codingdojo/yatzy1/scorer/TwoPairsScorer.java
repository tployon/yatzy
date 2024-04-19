package org.codingdojo.yatzy1.scorer;

import org.codingdojo.yatzy1.Scorer;
import org.codingdojo.yatzy1.Yatzy;

import java.util.List;

public class TwoPairsScorer implements Scorer {
    public TwoPairsScorer() {
    }

    public Integer score(Yatzy yatzy) {
        List<Integer> pairs = yatzy.atLeast(2);
        if (pairs.size() != 2)
            return Scorer.ZERO;

        return pairs
            .stream()
            .map(it -> it * 2)
            .reduce(0, Integer::sum);
    }
}