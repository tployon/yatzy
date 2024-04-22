package org.codingdojo.yatzy;

import org.codingdojo.yatzy.scorer.*;

public class YatzyGame {
    public static Integer score(DiceRoll diceRoll, Score score) {
        return score.score(diceRoll);
    }

    public enum Score {
        ONES(new NumberScorer(1)),
        TWOS(new NumberScorer(2)),
        THREES(new NumberScorer(3)),
        FOURS(new NumberScorer(4)),
        FIVES(new NumberScorer(5)),
        SIXES(new NumberScorer(6)),
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
