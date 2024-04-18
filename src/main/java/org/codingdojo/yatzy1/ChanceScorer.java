package org.codingdojo.yatzy1;

public class ChanceScorer implements Scorer {
    public ChanceScorer() {
    }

    public Integer score(Yatzy yatzy) {
        return yatzy.sum();
    }
}