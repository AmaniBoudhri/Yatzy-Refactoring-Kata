import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void chance() {
        assertEquals(15, Yatzy.chance(new DiceRoller(2, 3, 4, 5, 1)));
        assertEquals(16, Yatzy.chance(new DiceRoller(3, 3, 4, 5, 1)));
        assertEquals(14, Yatzy.chance(new DiceRoller(1, 1, 3, 3, 6)));
        assertEquals(21, Yatzy.chance(new DiceRoller(4, 5, 5, 6, 1)));
    }

    @Test
    public void yatzy() {
        assertEquals(50, Yatzy.yatzy(new DiceRoller(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy.yatzy(new DiceRoller(6, 6, 6, 6, 6)));
        assertEquals(0, Yatzy.yatzy(new DiceRoller(6, 6, 6, 6, 3)));
        assertEquals(50, Yatzy.yatzy(new DiceRoller(1, 1, 1, 1, 1)));
        assertEquals(0, Yatzy.yatzy(new DiceRoller(1, 1, 1, 2, 1)));
    }

    @Test
    public void ones() {
        assertEquals(1, Yatzy.ones(new DiceRoller(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new DiceRoller(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy.ones(new DiceRoller(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy.ones(new DiceRoller(1, 2, 1, 1, 1)));
        assertEquals(0, Yatzy.ones(new DiceRoller(3, 3, 3, 4, 5)));
    }

    @Test
    public void twos() {
        assertEquals(4, Yatzy.twos(new DiceRoller(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(new DiceRoller(2, 2, 2, 2, 2)));
        assertEquals(4, Yatzy.twos(new DiceRoller(2, 3, 2, 5, 1)));
    }

    @Test
    public void threes() {
        assertEquals(6, Yatzy.threes(new DiceRoller(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(new DiceRoller(2, 3, 3, 3, 3)));
    }

    @Test
    public void fours() {
        assertEquals(12, Yatzy.fours(4, 4, 4, 5, 5));
        assertEquals(8, Yatzy.fours(4, 4, 5, 5, 5));
        assertEquals(4, Yatzy.fours(4, 5, 5, 5, 5));
        assertEquals(8, Yatzy.fours(1, 1, 2, 4, 4));

    }

    @Test
    public void fives() {
        assertEquals(10, Yatzy.fives(4, 4, 4, 5, 5));
        assertEquals(15, Yatzy.fives(4, 4, 5, 5, 5));
        assertEquals(20, Yatzy.fives(4, 5, 5, 5, 5));
    }

    @Test
    public void sixes() {
        assertEquals(0, Yatzy.sixes(4, 4, 4, 5, 5));
        assertEquals(6, Yatzy.sixes(4, 4, 6, 5, 5));
        assertEquals(18, Yatzy.sixes(6, 5, 6, 6, 5));
    }

    @Test
    public void pair() {
        assertEquals(6, Yatzy.pair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.pair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.pair(5, 3, 6, 6, 5));
        assertEquals(8, Yatzy.pair(3, 3, 3, 4, 4));
        assertEquals(12, Yatzy.pair(1, 1, 6, 2, 6));
        assertEquals(6, Yatzy.pair(3, 3, 3, 4, 1));
        assertEquals(6, Yatzy.pair(3, 3, 3, 3, 1));
    }

    @Test
    public void twoPairs() {
        assertEquals(16, Yatzy.twoPairs(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.twoPairs(3, 3, 5, 5, 5));
        assertEquals(8, Yatzy.twoPairs(1, 1, 2, 3, 3));
        assertEquals(0, Yatzy.twoPairs(1, 1, 2, 3, 4));
        assertEquals(6, Yatzy.twoPairs(1, 1, 2, 2, 2));
    }

    @Test
    public void threeOfAKind() {
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.threeOfAKind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 5));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 3));
        assertEquals(0, Yatzy.threeOfAKind(3, 3, 4, 5, 6));
        assertEquals(9, Yatzy.threeOfAKind(3, 3, 3, 3, 1));
    }

    @Test
    public void fourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.fourOfAKind(5, 5, 5, 4, 5));
        assertEquals(8, Yatzy.fourOfAKind(2, 2, 2, 2, 5));
        assertEquals(0, Yatzy.fourOfAKind(2, 2, 2, 5, 5));
        assertEquals(8, Yatzy.fourOfAKind(2, 2, 2, 2, 2));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
        assertEquals(8, Yatzy.fullHouse(1, 1, 2, 2, 2));
        assertEquals(0, Yatzy.fullHouse(2, 2, 3, 3, 4));
        assertEquals(0, Yatzy.fullHouse(4, 4, 4, 4, 4));
    }
}
