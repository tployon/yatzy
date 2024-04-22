package org.codingdojo.yatzy;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class DiceRoll {

    private static final Set<Integer> VALID_DICES = Set.of(1, 2, 3, 4, 5, 6);
    private final List<Integer> dices;

    public static DiceRoll from(List<Integer> dices) {
        if (dices == null ||
            dices.size() < 5 ||
            dices.stream().anyMatch(it -> !VALID_DICES.contains(it))) throw new IllegalArgumentException("");
        return new DiceRoll(List.copyOf(dices));
    }

    private DiceRoll(List<Integer> dices) {
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

    @Override
    public String toString() {
        return "Dice Roll " + dices;
    }
}



