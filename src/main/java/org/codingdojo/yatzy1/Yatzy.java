package org.codingdojo.yatzy1;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class Yatzy {

    public static final int YATZY = 50;
    public static final int ZERO = 0;

    private final List<Integer> dices;

    public Yatzy(List<Integer> dices) {
        this.dices = dices;
    }

    public Map<Integer, Long> frequencies() {
        return dices.stream().collect(groupingBy(identity(), counting()));
    }

    public Integer sum() {
        return dices.stream().reduce(0, Integer::sum);
    }

    public List<Integer> filterDiceValue(int diceValue) {
        return dices.stream()
            .filter(it -> Objects.equals(it, diceValue))
            .collect(toList());
    }

    public List<Integer> atLeast(int atLeastFrequency) {
        return frequencies().entrySet()
            .stream()
            .filter(it -> it.getValue() >= atLeastFrequency)
            .map(Map.Entry::getKey)
            .toList();
    }

    //Future Yatzy interface
    public static Integer score(Yatzy yatzy, Score score) {
        return score.score(yatzy);
    }

    public int smallStraight() {
        return score(this, Score.SMALL_STRAIGHT);
    }

    public int largeStraight() {
        return score(this, Score.LARGE_STRAIGHT);
    }

    public int fullHouse() {
        Map<Integer, Long> frequencies = frequencies();
        if(frequencies.size() !=2 || !frequencies.containsValue(3L))
            return ZERO;
        return sum();
    }

}



