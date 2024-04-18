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

    private final List<Integer> dices;

    public Yatzy(List<Integer> dices) {
        this.dices = dices;
    }

    private List<Integer> atLeast(int atLeastFrequency) {
        return frequencies().entrySet().stream().filter(it -> it.getValue() >= atLeastFrequency).map(Map.Entry::getKey).toList();
    }

    private Map<Integer, Long> frequencies() {
        return dices.stream().collect(groupingBy(identity(), counting()));
    }

    private Integer sum() {
        return dices.stream().reduce(0, Integer::sum);
    }

    public List<Integer> filterDiceValue(int diceValue) {
        return dices.stream()
            .filter(it -> Objects.equals(it, diceValue))
            .collect(toList());
    }

    public List<Map.Entry<Integer, Long>> pairs() {
        return frequencies().entrySet().stream()
            .filter(it -> it.getValue() >= 2)
            .collect(toList());
    }


    /// to extract to scorer
    public int ones() {
        return score(this, Score.ONES);
    }

    //Future Yatzy interface
    public Integer score(Yatzy yatzy, Score score) {
        return score.score(yatzy);
    }

    public int twos() {
        return score(this, Score.TWOS);
    }

    public int threes() {
        return new ScorerNumber(3).score(this);
    }

    public int fours() {
        return new ScorerNumber(4).score(this);
    }

    public int fives() {
        return new ScorerNumber(5).score(this);
    }

    public int sixes() {
        return new ScorerNumber(6).score(this);
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

    public int three_of_a_kind() {
        return someOfAKind(3);
    }

    public int four_of_a_kind() {
        return someOfAKind(4);
    }

    private Integer someOfAKind(int atLeastFrequency) {
        return atLeast(atLeastFrequency)
            .stream()
            .findFirst()
            .map(it -> it * atLeastFrequency)
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



