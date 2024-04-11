package org.codingdojo.yatzy1;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Comparator.naturalOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class Yatzy {

    public static final int YATZY = 50;
    public static final int ZERO = 0;

    private static Integer scoreNumber(Yatzy yatzy, int diceValue) {
        return yatzy
            .filterDiceValue(diceValue)
            .stream()
            .reduce(0, Integer::sum);
    }

    public static int threes(Yatzy yatzy) {
        return scoreNumber(yatzy, 3);
    }

    private final List<Integer> dices;

    public Yatzy(List<Integer> dices) {
        this.dices = dices;
    }

    private List<Integer> atLeast(int atLeastFrequency) {
        return frequencies().entrySet().stream().filter(it -> it.getValue() == atLeastFrequency).map(Map.Entry::getKey).toList();
    }

    private Map<Integer, Long> frequencies() {
        return dices.stream().collect(groupingBy(identity(), counting()));
    }

    private Integer sum() {
        return dices.stream().reduce(0, Integer::sum);
    }

    private List<Integer> filterDiceValue(int diceValue) {
        return dices.stream()
            .filter(it -> Objects.equals(it, diceValue))
            .collect(toList());
    }

    public List<Map.Entry<Integer, Long>> pairs() {
        return frequencies().entrySet().stream()
            .filter(it -> it.getValue() >= 2)
            .collect(toList());
    }

    public int ones() {
        return scoreNumber(this, 1);
    }

    public int twos() {
        return scoreNumber(this, 2);
    }

    public int fours() {
        return scoreNumber(this, 4);
    }

    public int fives() {
        return scoreNumber(this, 5);
    }

    public int sixes() {
        return scoreNumber(this, 6);
    }

    public int chance() {
        return sum();
    }

    public int yatzy() {
        return frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 5)
            .map(it -> Yatzy.YATZY)
            .findFirst()
            .orElse(Yatzy.ZERO);
    }

    public int score_pair() {
        return pairs()
            .stream()
            .map(Map.Entry::getKey)
            .max(naturalOrder())
            .map(it -> it * 2)
            .orElse(ZERO);
    }

    public int two_pair() {
        List<Map.Entry<Integer, Long>> pairs = pairs();
        if (pairs.size() !=2)
            return ZERO;

        return pairs
            .stream()
            .map(Map.Entry::getKey)
            .map(it -> it * 2)
            .reduce(0, Integer::sum);
    }

    public static int four_of_a_kind(Yatzy yatzy) {
        return yatzy.atLeast(4)
            .stream()
            .findFirst()
            .map(it -> it * 4)
            .orElse(ZERO);
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1 - 1]++;
        t[d2 - 1]++;
        t[d3 - 1]++;
        t[d4 - 1]++;
        t[d5 - 1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



