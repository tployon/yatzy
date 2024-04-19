package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.Scorer;
import org.codingdojo.yatzy.Yatzy;

public class ChanceScorer implements Scorer {
    public ChanceScorer() {
    }

    public Integer score(Yatzy yatzy) {
        return yatzy.sum();
    }
}