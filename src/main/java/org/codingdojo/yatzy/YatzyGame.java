package org.codingdojo.yatzy;

import org.codingdojo.yatzy.scorer.*;

public class YatzyGame {
    public static Integer score(DiceRoll diceRoll, Score score) {
        return score.score(diceRoll);
    }

    public enum Score {
        ONES(new ScorerNumber(1)),
        TWOS(new ScorerNumber(2)),
        THREES(new ScorerNumber(3)),
        FOURS(new ScorerNumber(4)),
        FIVES(new ScorerNumber(5)),
        SIXES(new ScorerNumber(6)),
        CHANCE(new ChanceScorer()),
        YATZY(new YatzyScorer()),
        PAIR(new PairScorer()),
        TWO_PAIRS(new TwoPairsScorer()),
        THREE_OF_A_KIND(new SomeOfAKindScorer(3)),
        FOUR_OF_A_KIND(new SomeOfAKindScorer(4)),
        SMALL_STRAIGHT(new AllButScorer(6)),
        LARGE_STRAIGHT(new AllButScorer(1)),
        FULL_HOUSE(new FullHouseScorer());

        private final Scorer scorer;

        Score(Scorer scorer) {
            this.scorer = scorer;
        }

        Integer score(DiceRoll diceRoll) {
            return scorer.score(diceRoll);
        }

    }
}