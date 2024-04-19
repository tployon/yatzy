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
    @DisplayName("Ones scores ")
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

    @Test
    public void test_2s() {
        assertEquals(4, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 2, 6)), TWOS));
        assertEquals(10, Yatzy.score(new DiceRoll(List.of(2, 2, 2, 2, 2)), TWOS));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 2, 3)), THREES));
        assertEquals(12, Yatzy.score(new DiceRoll(List.of(2, 3, 3, 3, 3)), THREES));
    }

    @Test
    public void fours_test() {
        assertEquals(12, Yatzy.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), FOURS));
        assertEquals(8, Yatzy.score(new DiceRoll(List.of(4, 4, 5, 5, 5)), FOURS));
        assertEquals(4, Yatzy.score(new DiceRoll(List.of(4, 5, 5, 5, 5)), FOURS));
    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), FIVES));
        assertEquals(15, Yatzy.score(new DiceRoll(List.of(4, 4, 5, 5, 5)), FIVES));
        assertEquals(20, Yatzy.score(new DiceRoll(List.of(4, 5, 5, 5, 5)), FIVES));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, Yatzy.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), SIXES));
        assertEquals(6, Yatzy.score(new DiceRoll(List.of(4, 4, 6, 5, 5)), SIXES));
        assertEquals(18, Yatzy.score(new DiceRoll(List.of(6, 5, 6, 6, 5)), SIXES));
    }

    @Test
    public void one_pair() {
        assertEquals(6, Yatzy.score(new DiceRoll(List.of(3, 4, 3, 5, 6)), PAIR));
        assertEquals(10, Yatzy.score(new DiceRoll(List.of(5, 3, 3, 3, 5)), PAIR));
        assertEquals(12, Yatzy.score(new DiceRoll(List.of(5, 3, 6, 6, 5)), PAIR));
        assertEquals(0, Yatzy.score(new DiceRoll(List.of(5, 3, 1, 6, 2)), PAIR));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.score(new DiceRoll(List.of(3, 3, 5, 4, 5)), TWO_PAIRS));
        assertEquals(16, Yatzy.score(new DiceRoll(List.of(3, 3, 5, 5, 5)), TWO_PAIRS));
        assertEquals(0, Yatzy.score(new DiceRoll(List.of(3, 3, 1, 2, 5)), TWO_PAIRS));
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, Yatzy.score(new DiceRoll(List.of(3, 3, 3, 4, 5)), THREE_OF_A_KIND));
        assertEquals(15, Yatzy.score(new DiceRoll(List.of(5, 3, 5, 4, 5)), THREE_OF_A_KIND));
        assertEquals(9, Yatzy.score(new DiceRoll(List.of(3, 3, 3, 3, 5)), THREE_OF_A_KIND));
        assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 3, 5)), THREE_OF_A_KIND));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, Yatzy.score(new DiceRoll(List.of(3, 3, 3, 3, 5)), FOUR_OF_A_KIND));
        assertEquals(20, Yatzy.score(new DiceRoll(List.of(5, 5, 5, 4, 5)), FOUR_OF_A_KIND));
        assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 4, 3)), FOUR_OF_A_KIND));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.score(new DiceRoll(List.of(1, 2, 3, 4, 5)), SMALL_STRAIGHT));
        assertEquals(15, Yatzy.score(new DiceRoll(List.of(2, 3, 4, 5, 1)), SMALL_STRAIGHT));
        assertEquals(0, Yatzy.score(new DiceRoll(List.of(1, 2, 2, 4, 5)), SMALL_STRAIGHT));
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
