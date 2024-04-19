package org.codingdojo.yatzy1.scorer;

import org.codingdojo.yatzy1.Scorer;
import org.codingdojo.yatzy1.Yatzy;

import java.util.Map;

public class FullHouseScorer implements Scorer {

    public FullHouseScorer() {
    }

    public Integer score(Yatzy yatzy) {
        Map<Integer, Long> frequencies = yatzy.frequencies();
        if (frequencies.size() != 2 || !frequencies.containsValue(3L))
            return Yatzy.ZERO;
        return yatzy.sum();
    }
}