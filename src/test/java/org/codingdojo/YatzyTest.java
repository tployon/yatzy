package org.codingdojo;

import org.codingdojo.yatzy.Score;
import org.codingdojo.yatzy.DiceRoll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        DiceRoll yatzy1 = new DiceRoll(List.of(2, 3, 4, 5, 1));
        assertEquals(15, (int) DiceRoll.score(yatzy1, Score.CHANCE));
        DiceRoll yatzy = new DiceRoll(List.of(3, 3, 4, 5, 1));
        assertEquals(16, (int) DiceRoll.score(yatzy, Score.CHANCE));
    }

    @Test public void yatzy_scores_50() {
        final Integer[] integers = new Integer[]{4, 4, 4, 4, 4};
        final List<Integer> list = Arrays.asList(integers);
        DiceRoll yatzy2 = new DiceRoll(list);
        assertEquals(50, (int) DiceRoll.score(yatzy2, Score.YATZY));
        final Integer[] integers1 = new Integer[]{6, 6, 6, 6, 6};
        final List<Integer> list1 = Arrays.asList(integers1);
        DiceRoll yatzy1 = new DiceRoll(list1);
        assertEquals(50, (int) DiceRoll.score(yatzy1, Score.YATZY));
        final Integer[] integers2 = new Integer[]{6, 6, 6, 6, 3};
        final List<Integer> list2 = Arrays.asList(integers2);
        DiceRoll yatzy = new DiceRoll(list2);
        assertEquals(0, (int) DiceRoll.score(yatzy, Score.YATZY));
    }

    @Test public void test_1s() {
        assertEquals(1, (int) DiceRoll.score(new DiceRoll(List.of(1, 2, 3, 4, 5)), Score.ONES));
        assertEquals(2, (int) DiceRoll.score(new DiceRoll(List.of(1, 2, 1, 4, 5)), Score.ONES));
        assertEquals(0, (int) DiceRoll.score(new DiceRoll(List.of(6, 2, 2, 4, 5)), Score.ONES));
        assertEquals(4, (int) DiceRoll.score(new DiceRoll(List.of(1, 2, 1, 1, 1)), Score.ONES));
    }

    @Test
    public void test_2s() {
        assertEquals(4, (int) DiceRoll.score(new DiceRoll(List.of(1, 2, 3, 2, 6)), Score.TWOS));
        assertEquals(10, (int) DiceRoll.score(new DiceRoll(List.of(2, 2, 2, 2, 2)), Score.TWOS));
    }

    @Test
    public void test_threes() {
        assertEquals(6, (int) DiceRoll.score(new DiceRoll(List.of(1, 2, 3, 2, 3)), Score.THREES));
        assertEquals(12, (int) DiceRoll.score(new DiceRoll(List.of(2, 3, 3, 3, 3)), Score.THREES));
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12, (int) DiceRoll.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), Score.FOURS));
        assertEquals(8, (int) DiceRoll.score(new DiceRoll(List.of(4, 4, 5, 5, 5)), Score.FOURS));
        assertEquals(4, (int) DiceRoll.score(new DiceRoll(List.of(4, 5, 5, 5, 5)), Score.FOURS));
    }

    @Test
    public void fives() {
        assertEquals(10, (int) DiceRoll.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), Score.FIVES));
        assertEquals(15, (int) DiceRoll.score(new DiceRoll(List.of(4, 4, 5, 5, 5)), Score.FIVES));
        assertEquals(20, (int) DiceRoll.score(new DiceRoll(List.of(4, 5, 5, 5, 5)), Score.FIVES));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, (int) DiceRoll.score(new DiceRoll(List.of(4, 4, 4, 5, 5)), Score.SIXES));
        assertEquals(6, (int) DiceRoll.score(new DiceRoll(List.of(4, 4, 6, 5, 5)), Score.SIXES));
        assertEquals(18, (int) DiceRoll.score(new DiceRoll(List.of(6, 5, 6, 6, 5)), Score.SIXES));
    }

    @Test
    public void one_pair() {
        DiceRoll yatzy3 = new DiceRoll(List.of(3, 4, 3, 5, 6));
        assertEquals(6, (int) DiceRoll.score(yatzy3, Score.PAIR));
        DiceRoll yatzy2 = new DiceRoll(List.of(5, 3, 3, 3, 5));
        assertEquals(10, (int) DiceRoll.score(yatzy2, Score.PAIR));
        DiceRoll yatzy1 = new DiceRoll(List.of(5, 3, 6, 6, 5));
        assertEquals(12, (int) DiceRoll.score(yatzy1, Score.PAIR));
        DiceRoll yatzy = new DiceRoll(List.of(5, 3, 1, 6, 2));
        assertEquals(0, (int) DiceRoll.score(yatzy, Score.PAIR));
    }

    @Test
    public void two_Pair() {
        DiceRoll yatzy2 = new DiceRoll(List.of(3, 3, 5, 4, 5));
        assertEquals(16, (int) DiceRoll.score(yatzy2, Score.TWO_PAIRS));
        DiceRoll yatzy1 = new DiceRoll(List.of(3, 3, 5, 5, 5));
        assertEquals(16, (int) DiceRoll.score(yatzy1, Score.TWO_PAIRS));
        DiceRoll yatzy = new DiceRoll(List.of(3, 3, 1, 2, 5));
        assertEquals(0, (int) DiceRoll.score(yatzy, Score.TWO_PAIRS));
    }

    @Test
    public void three_of_a_kind() 
    {
        DiceRoll yatzy3 = new DiceRoll(List.of(3, 3, 3, 4, 5));
        assertEquals(9, (int) DiceRoll.score(yatzy3, Score.THREE_OF_A_KIND));
        DiceRoll yatzy2 = new DiceRoll(List.of(5, 3, 5, 4, 5));
        assertEquals(15, (int) DiceRoll.score(yatzy2, Score.THREE_OF_A_KIND));
        DiceRoll yatzy1 = new DiceRoll(List.of(3, 3, 3, 3, 5));
        assertEquals(9, (int) DiceRoll.score(yatzy1, Score.THREE_OF_A_KIND));
        DiceRoll yatzy = new DiceRoll(List.of(1, 2, 3, 3, 5));
        assertEquals(0, (int) DiceRoll.score(yatzy, Score.THREE_OF_A_KIND));
    }

    @Test
    public void four_of_a_knd() {
        DiceRoll yatzy2 = new DiceRoll(List.of(3, 3, 3, 3, 5));
        assertEquals(12, (int) DiceRoll.score(yatzy2, Score.FOUR_OF_A_KIND));
        DiceRoll yatzy1 = new DiceRoll(List.of(5, 5, 5, 4, 5));
        assertEquals(20, (int) DiceRoll.score(yatzy1, Score.FOUR_OF_A_KIND));
        DiceRoll yatzy = new DiceRoll(List.of(1, 2, 3, 4, 3));
        assertEquals(0, (int) DiceRoll.score(yatzy, Score.FOUR_OF_A_KIND));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, (int) DiceRoll.score(new DiceRoll(List.of(1, 2, 3, 4, 5)), Score.SMALL_STRAIGHT));
        assertEquals(15, (int) DiceRoll.score(new DiceRoll(List.of(2, 3, 4, 5, 1)), Score.SMALL_STRAIGHT));
        assertEquals(0, (int) DiceRoll.score(new DiceRoll(List.of(1, 2, 2, 4, 5)), Score.SMALL_STRAIGHT));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, (int) DiceRoll.score(new DiceRoll(List.of(6, 2, 3, 4, 5)), Score.LARGE_STRAIGHT));
        assertEquals(20, (int) DiceRoll.score(new DiceRoll(List.of(2, 3, 4, 5, 6)), Score.LARGE_STRAIGHT));
        assertEquals(0, (int) DiceRoll.score(new DiceRoll(List.of(1, 2, 2, 4, 5)), Score.LARGE_STRAIGHT));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, (int) DiceRoll.score(new DiceRoll(List.of(6, 2, 2, 2, 6)), Score.FULL_HOUSE));
        assertEquals(0, (int) DiceRoll.score(new DiceRoll(List.of(2, 3, 4, 5, 6)), Score.FULL_HOUSE));
    }
}
