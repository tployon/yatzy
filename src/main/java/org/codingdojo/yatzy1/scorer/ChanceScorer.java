package org.codingdojo.yatzy1.scorer;

import org.codingdojo.yatzy1.Scorer;
import org.codingdojo.yatzy1.Yatzy;

public class ChanceScorer implements Scorer {
    public ChanceScorer() {
    }

    public Integer score(Yatzy yatzy) {
        return yatzy.sum();
    }
}