package org.codingdojo.yatzy;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class DiceRoll {

    private final List<Integer> dices;

    public DiceRoll(List<Integer> dices) {
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
    public static Integer score(DiceRoll yatzy, Score score) {
        return score.score(yatzy);
    }

}



