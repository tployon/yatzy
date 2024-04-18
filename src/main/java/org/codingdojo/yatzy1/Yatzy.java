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
    private final ChanceScorer chanceScorer = new ChanceScorer();
    private final YatzyScorer yatzyScorer = new YatzyScorer();
    private final PairScorer pairScorer = new PairScorer();
    private final TwoPairsScorer twoPairsScorer = new TwoPairsScorer();

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

    public int three_of_a_kind() {
        return someOfAKind(new SomeOfAKindScorer(3), this);
    }

    public int four_of_a_kind() {
        return someOfAKind(new SomeOfAKindScorer(4), this);
    }

    private Integer someOfAKind(SomeOfAKindScorer someOfAKindScorer, Yatzy yatzy) {
        return yatzy.atLeast(someOfAKindScorer.atLeastFrequency())
            .stream()
            .findFirst()
            .map(it -> it * someOfAKindScorer.atLeastFrequency())
            .orElse(ZERO);
    }

    public int smallStraight() {
        long count = frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 1)
            .filter(it -> !Objects.equals(it.getKey(), 6))
            .count();
        if(count != 5)
            return ZERO;
        return sum();
    }

    public int largeStraight() {
        long count = frequencies()
            .entrySet()
            .stream()
            .filter(it -> it.getValue() == 1)
            .filter(it -> !Objects.equals(it.getKey(), 1))
            .count();
        if(count != 5)
            return ZERO;
        return sum();
    }

    public int fullHouse() {
        Map<Integer, Long> frequencies = frequencies();
        if(frequencies.size() !=2 || !frequencies.containsValue(3L))
            return ZERO;
        return sum();
    }

}



