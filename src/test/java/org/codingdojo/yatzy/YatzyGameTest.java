package org.codingdojo.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.codingdojo.yatzy.YatzyGame.Score.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyGameTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, YatzyGame.score(new DiceRoll(List.of(2, 3, 4, 5, 1)), CHANCE));
    }

    @Nested
    @DisplayName("Yatzy scores ")
    public class Yatzy {

        private static Stream<DiceRoll> yatzies() {
            return Stream.of(new DiceRoll(List.of(4, 4, 4, 4, 4)), new DiceRoll(List.of(6, 6, 6, 6, 6)));
        }

        @ParameterizedTest
        @MethodSource("yatzies")
        @DisplayName("50")
        public void _50(DiceRoll diceRoll) {
            assertEquals(50, YatzyGame.score(diceRoll, YATZY));
        }

        @Test
        @DisplayName("0")
        public void _0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(6, 6, 6, 6, 3)), YATZY));
        }
    }


    @Nested
    public class Ones {

        @Test
        public void two_ones_scores_2() {
            assertEquals(2, YatzyGame.score(new DiceRoll(List.of(1, 2, 3, 1, 5)), ONES));
        }


        @Test
        public void no_one_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(6, 2, 2, 4, 5)), ONES));
        }

    }

    @Nested
    public class Twos {

        @Test
        public void five_twos_scores_10() {
            assertEquals(10, YatzyGame.score(new DiceRoll(List.of(2, 2, 2, 2, 2)), TWOS));
        }

        @Test
        public void no_two_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(1, 1, 1, 1, 1)), TWOS));
        }
    }

    @Nested
    public class Threes {
        @Test
        public void two_threes_scores_6() {
            assertEquals(6, YatzyGame.score(new DiceRoll(List.of(1, 2, 3, 2, 3)), THREES));
        }

        @Test
        public void no_threes_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(1, 2, 4, 2, 4)), THREES));
        }
    }

    @Nested
    public class Fours {
        @Test
        public void three_fours_scores_12() {
            assertEquals(12, YatzyGame.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), FOURS));
        }

        @Test
        void no_fours_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(1, 1, 1, 5, 5)), FOURS));
        }
    }


    @Nested
    public class Fives {
        @Test
        public void two_fives_scores_10() {
            assertEquals(10, YatzyGame.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), FIVES));
        }

        @Test
        public void no_five_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(4, 4, 4, 4, 4)), FIVES));
        }
    }

    @Nested
    public class Sixes {

        @Test
        public void three_sixes_scores_18() {
            assertEquals(18, YatzyGame.score(new DiceRoll(List.of(6, 5, 6, 6, 5)), SIXES));
        }

        @Test
        public void no_six_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(1, 5, 2, 3, 5)), SIXES));
        }
    }

    @Nested
    public class OnePair {

        @Test
        public void one_pair_scores_the_pair_sum() {
            assertEquals(12, YatzyGame.score(new DiceRoll(List.of(1, 3, 6, 6, 5)), PAIR));
        }

        @Test
        public void greatest_pair_scores() {
            assertEquals(10, YatzyGame.score(new DiceRoll(List.of(5, 3, 3, 3, 5)), PAIR));
        }

        @Test
        void no_pair_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(5, 3, 1, 6, 2)), PAIR));
        }
    }

    @Nested
    public class TwoPairs {

        @Test
        public void two_pairs_scores_pairs_sum() {
            assertEquals(16, YatzyGame.score(new DiceRoll(List.of(3, 3, 5, 5, 5)), TWO_PAIRS));
        }

        @Test
        void one_pair_is_not_enough_to_score() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(3, 3, 1, 2, 5)), TWO_PAIRS));
        }
    }

    @Nested
    public class Three0fAKind {
        @Test
        public void three_of_a_kind_scores_only_three_of_the_kind() {
            assertEquals(15, YatzyGame.score(new DiceRoll(List.of(5, 3, 5, 5, 5)), THREE_OF_A_KIND));
        }

        @Test
        void no_three_of_a_kind_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(1, 2, 3, 3, 5)), THREE_OF_A_KIND));
        }

    }


    @Nested
    public class Four0fAKind {
        @Test
        public void four_of_a_kind_scores_only_four_of_the_kind() {
            assertEquals(12, YatzyGame.score(new DiceRoll(List.of(3, 3, 3, 3, 3)), FOUR_OF_A_KIND));
        }

        @Test
        void no_four_of_a_kind_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(1, 2, 3, 4, 3)), FOUR_OF_A_KIND));
        }

    }

    @Nested
    public class SmallStraight {
        @Test
        public void small_straight_scores_the_sum() {
            assertEquals(15, YatzyGame.score(new DiceRoll(List.of(2, 3, 4, 5, 1)), SMALL_STRAIGHT));
        }

        @Test
        void no_small_straight_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(1, 2, 2, 4, 5)), SMALL_STRAIGHT));
        }
    }


    @Nested
    public class LargeStraight {

        @Test
        public void large_straight_scores_the_sum() {
            assertEquals(20, YatzyGame.score(new DiceRoll(List.of(6, 2, 3, 4, 5)), LARGE_STRAIGHT));
        }

        @Test
        void no_large_straight_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(1, 2, 2, 4, 5)), LARGE_STRAIGHT));
        }
    }

    @Nested
    public class FullHouse {

        @Test
        public void full_house_scores_the_sum() {
            assertEquals(18, YatzyGame.score(new DiceRoll(List.of(6, 2, 2, 2, 6)), FULL_HOUSE));
        }

        @Test
        public void four_of_a_kind_is_not_a_full_house() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(6, 6, 6, 2, 6)), FULL_HOUSE));
        }

        @Test
        void no_full_house_scores_0() {
            assertEquals(0, YatzyGame.score(new DiceRoll(List.of(2, 3, 4, 5, 6)), FULL_HOUSE));
        }
    }
}
