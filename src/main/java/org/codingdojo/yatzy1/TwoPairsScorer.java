package org.codingdojo.yatzy1;

import java.util.List;

public class TwoPairsScorer implements Scorer{
    public TwoPairsScorer() {
    }

    public Integer score(Yatzy yatzy) {
        List<Integer> pairs = yatzy.atLeast(2);
        if (pairs.size() != 2)
            return Yatzy.ZERO;

        return pairs
            .stream()
            .map(it -> it * 2)
            .reduce(0, Integer::sum);
    }
}