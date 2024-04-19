package org.codingdojo.yatzy.scorer;

import org.codingdojo.yatzy.DiceRoll;

public interface Scorer {
    int ZERO = 0;

    Integer score(DiceRoll diceRoll);
}
