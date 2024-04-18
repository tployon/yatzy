package org.codingdojo.yatzy1;

public enum Score {
    ONES(new ScorerNumber(1)), TWOS(new ScorerNumber(2));

    private final Scorer scorer;

    Score(Scorer scorer) {
        this.scorer = scorer;
    }

    Integer score(Yatzy yatzy) {
        return scorer.score(yatzy);
    }

}
