package org.codingdojo.yatzy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiceRollTest {

    public static Stream invalidDiceRolls() {
        return Stream.of(EMPTY_LIST, List.of(1,2,3,4), null);
    }

    @ParameterizedTest
    @MethodSource("invalidDiceRolls")
    void a_dice_roll_with_less_than_5_dices_is_invalid(List<Integer> dices) {
        assertThatThrownBy(() -> DiceRoll.from(dices))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void dice_values_are_between_1_and_6() {
        assertThatThrownBy(() -> DiceRoll.from(List.of(1,2,3,4,5,7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void valid_dice_roll() {
        assertThat(DiceRoll.from(List.of(1,2,3,4,5,6)).sum())
            .isEqualTo(21);
    }

    @Test
    void dice_roll_is_immutable() {
        List<Integer> dices = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        DiceRoll diceRoll = DiceRoll.from(dices);
        dices.add(1);
        assertThat(diceRoll.sum()).isEqualTo(21);
    }
}