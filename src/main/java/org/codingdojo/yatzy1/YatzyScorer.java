package org.codingdojo.yatzy1;

public class YatzyScorer implements Scorer {
    public static final int YATZY = 50;

    public YatzyScorer() {
    }

    public Integer score(Yatzy yatzy) {
        return yatzy.frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 5)
            .map(it -> YATZY)
            .findFirst()
            .orElse(Yatzy.ZERO);
    }
}