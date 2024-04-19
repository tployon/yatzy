package org.codingdojo.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.codingdojo.yatzy.Yatzy.Score.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.score(new DiceRoll(List.of(2, 3, 4, 5, 1)), CHANCE));
    }

    @Nested
    @DisplayName("Yatzy scores ")
    public class YatzyScore {

        private static Stream<DiceRoll> yatzies() {
            return Stream.of(new DiceRoll(List.of(4, 4, 4, 4, 4)), new DiceRoll(List.of(6, 6, 6, 6, 6)));
        }

        @ParameterizedTest
        @MethodSource("yatzies")
        @DisplayName("50")
        public void _50(DiceRoll diceRoll) {
            assertEquals(50, Yatzy.score(diceRoll, YATZY));
        }

        @Test
        @DisplayName("0")
        public void _0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(6, 6, 6, 6, 3)), YATZY));
        }
    }


    @Nested
    public class OnesScore {

        @Test
        public void two_ones_scores_2() {
            assertEquals(2, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 1, 5)), ONES));
        }


        @Test
        public void no_one_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(6, 2, 2, 4, 5)), ONES));
        }

    }

    @Nested
    public class TwosScore {

        @Test
        public void five_twos_scores_10() {
            assertEquals(10, Yatzy.score(new DiceRoll(List.of(2, 2, 2, 2, 2)), TWOS));
        }

        @Test
        public void no_two_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 1, 1, 1, 1)), TWOS));
        }
    }

    @Nested
    public class ThreesScore {
        @Test
        public void two_threes_scores_6() {
            assertEquals(6, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 2, 3)), THREES));
        }

        @Test
        public void no_threes_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 2, 4, 2, 4)), THREES));
        }
    }

    @Nested
    public class FoursScore {
        @Test
        public void three_fours_scores_12() {
            assertEquals(12, Yatzy.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), FOURS));
        }

        @Test
        void no_fours_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 1, 1, 5, 5)), FOURS));
        }
    }


    @Nested
    public class FivesScore {
        @Test
        public void two_fives_scores_10() {
            assertEquals(10, Yatzy.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), FIVES));
        }

        @Test
        public void no_five_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(4, 4, 4, 4, 4)), FIVES));
        }
    }

    @Nested
    public class SixesScore {

        @Test
        public void three_sixes_scores_18() {
            assertEquals(18, Yatzy.score(new DiceRoll(List.of(6, 5, 6, 6, 5)), SIXES));
        }

        @Test
        public void no_six_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 5, 2, 3, 5)), SIXES));
        }
    }

    @Nested
    public class OnePairScore {

        @Test
        public void one_pair_scores_the_pair_sum() {
            assertEquals(12, Yatzy.score(new DiceRoll(List.of(1, 3, 6, 6, 5)), PAIR));
        }

        @Test
        public void greatest_pair_scores() {
            assertEquals(10, Yatzy.score(new DiceRoll(List.of(5, 3, 3, 3, 5)), PAIR));
        }

        @Test
        void no_pair_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(5, 3, 1, 6, 2)), PAIR));
        }
    }

    @Nested
    public class TwoPairsScore {

        @Test
        public void two_pairs_scores_pairs_sum() {
            assertEquals(16, Yatzy.score(new DiceRoll(List.of(3, 3, 5, 5, 5)), TWO_PAIRS));
        }

        @Test
        void one_pair_is_not_enough_to_score() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(3, 3, 1, 2, 5)), TWO_PAIRS));
        }
    }

    @Nested
    public class Three0fAKindScore {
        @Test
        public void three_of_a_kind_scores_only_three_of_the_kind() {
            assertEquals(15, Yatzy.score(new DiceRoll(List.of(5, 3, 5, 5, 5)), THREE_OF_A_KIND));
        }

        @Test
        void no_three_of_a_kind_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 3, 5)), THREE_OF_A_KIND));
        }

    }


    @Nested
    public class Four0fAKindScore {
        @Test
        public void four_of_a_kind_scores_only_four_of_the_kind() {
            assertEquals(12, Yatzy.score(new DiceRoll(List.of(3, 3, 3, 3, 3)), FOUR_OF_A_KIND));
        }

        @Test
        void no_four_of_a_kind_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 4, 3)), FOUR_OF_A_KIND));
        }

    }

    @Nested
    public class SmallStraightScore {
        @Test
        public void small_straight_scores_the_sum() {
            assertEquals(15, Yatzy.score(new DiceRoll(List.of(2, 3, 4, 5, 1)), SMALL_STRAIGHT));
        }

        @Test
        void no_small_straight_scores_0() {
            assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 2, 2, 4, 5)), SMALL_STRAIGHT));
        }
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.score(new DiceRoll(List.of(6, 2, 3, 4, 5)), LARGE_STRAIGHT));
        assertEquals(20, Yatzy.score(new DiceRoll(List.of(2, 3, 4, 5, 6)), LARGE_STRAIGHT));
        assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 2, 2, 4, 5)), LARGE_STRAIGHT));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.score(new DiceRoll(List.of(6, 2, 2, 2, 6)), FULL_HOUSE));
        assertEquals(0, Yatzy.score(new DiceRoll(List.of(2, 3, 4, 5, 6)), FULL_HOUSE));
    }
}
