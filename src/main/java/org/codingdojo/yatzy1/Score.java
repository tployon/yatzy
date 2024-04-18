package org.codingdojo.yatzy1;

public enum Score {
    ONES(new ScorerNumber(1));

    private final Scorer scorer;

    Score(Scorer scorer) {
        this.scorer = scorer;
    }

    Integer getScore(Yatzy yatzy) {
        return scorer.score(yatzy);
    }

}
