package org.codingdojo.yatzy1;

public class YatzyScorer implements Scorer {
    public YatzyScorer() {
    }

    public Integer score(Yatzy yatzy) {
        return yatzy.frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 5)
            .map(it -> Yatzy.YATZY)
            .findFirst()
            .orElse(Yatzy.ZERO);
    }
}