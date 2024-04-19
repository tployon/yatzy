package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.Scorer;
import org.codingdojo.yatzy.Yatzy;

import java.util.Map;

public class FullHouseScorer implements Scorer {

    public FullHouseScorer() {
    }

    public Integer score(Yatzy yatzy) {
        Map<Integer, Long> frequencies = yatzy.frequencies();
        if (frequencies.size() != 2 || !frequencies.containsValue(3L))
            return Scorer.ZERO;
        return yatzy.sum();
    }
}