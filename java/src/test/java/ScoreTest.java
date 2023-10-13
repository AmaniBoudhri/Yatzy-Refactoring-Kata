import static org.junit.jupiter.api.Assertions.assertEquals;
import static yatzy.Category.Chance;
import static yatzy.Category.Fives;
import static yatzy.Category.FourOfAKind;
import static yatzy.Category.Fours;
import static yatzy.Category.FullHouse;
import static yatzy.Category.LargeStraight;
import static yatzy.Category.Pair;
import static yatzy.Category.Sixes;
import static yatzy.Category.SmallStraight;
import static yatzy.Category.ThreeOfAKind;
import static yatzy.Category.Threes;
import static yatzy.Category.TwoPairs;
import static yatzy.Category.Twos;
import static yatzy.Category.Yatzy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import yatzy.CategoryEnum;
import yatzy.DiceRoller;
import yatzy.Party;
import yatzy.factory.PartyFactory;

public class ScoreTest {
	@ParameterizedTest
	@CsvSource({ "2, 3, 4, 5, 1,15", "3, 3, 4, 5, 1,16", "1, 1, 3, 3, 6,14", "4, 5, 5, 6, 1,21" })
	public void chance(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, Chance.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}

	@ParameterizedTest
	@CsvSource({ "4, 4, 4, 4, 4,50", "6, 6, 6, 6, 6,50", "6, 6, 6, 6, 3,0", "1, 1, 1, 1, 1,50", "1, 1, 1, 2, 1,0" })
	public void yatzy(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, Yatzy.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3, 4, 5,1", "1, 2, 1, 4, 5,2", "6, 2, 2, 4, 5,0", "1, 2, 1, 1, 1,4", "3, 3, 3, 4, 5,0" })
	public void ones(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(d1, d2, d3, d4, d5);
		Party ones = factory.createParty(CategoryEnum.ONES);
		assertEquals(expected, ones.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3, 2, 6,4", "2, 2, 2, 2, 2,10", "2, 3, 2, 5, 1,4" })
	public void twos(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, Twos.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
		PartyFactory factory = new PartyFactory(d1, d2, d3, d4, d5);
		Party twos = factory.createParty(CategoryEnum.TWOS);
		assertEquals(expected, twos.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3, 2, 3,6", "2, 3, 3, 3, 3,12" })
	public void threes(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, Threes.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
		PartyFactory factory = new PartyFactory(d1, d2, d3, d4, d5);
		Party threes = factory.createParty(CategoryEnum.THREES);
		assertEquals(expected, threes.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "4, 4, 4, 5, 5,12", "4, 4, 5, 5, 5,8", "4, 5, 5, 5, 5,4", "1, 1, 2, 4, 4,8" })
	public void fours(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, Fours.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
		PartyFactory factory = new PartyFactory(d1, d2, d3, d4, d5);
		Party fours = factory.createParty(CategoryEnum.FOURS);
		assertEquals(expected, fours.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "4, 4, 4, 5, 5,10", "4, 4, 5, 5, 5,15", "4, 5, 5, 5, 5,20" })
	public void fives(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, Fives.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
		PartyFactory factory = new PartyFactory(d1, d2, d3, d4, d5);
		Party fives = factory.createParty(CategoryEnum.FIVES);
		assertEquals(expected, fives.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "4, 4, 4, 5, 5,0", "4, 4, 6, 5, 5,6", "6, 5, 6, 6, 5,18" })
	public void sixes(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, Sixes.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
		PartyFactory factory = new PartyFactory(d1, d2, d3, d4, d5);
		Party sixes = factory.createParty(CategoryEnum.SIXES);
		assertEquals(expected, sixes.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "3, 4, 3, 5, 6,6", "5, 3, 3, 3, 5,10", "5, 3, 6, 6, 5,12", "3, 3, 3, 4, 4,8", "1, 1, 6, 2, 6,12",
			"3, 3, 3, 4, 1,6", "3, 3, 3, 3, 1,6" })
	public void pair(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, Pair.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}

	@ParameterizedTest
	@CsvSource({ "3, 3, 5, 4, 5,16", "3, 3, 5, 5, 5,16", "1, 1, 2, 3, 3,8", "1, 1, 2, 3, 4,0", "1, 1, 2, 2, 2,6" })
	public void twoPair(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, TwoPairs.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}

	@ParameterizedTest
	@CsvSource({ "3, 3, 3, 4, 5,9", "5, 3, 5, 4, 5,15", "3, 3, 3, 3, 5,9", "3, 3, 3, 3, 3,9", "3, 3, 4, 5, 6,0",
			"3, 3, 3, 3, 1,9" })
	public void threeOfAKind(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, ThreeOfAKind.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}

	@ParameterizedTest
	@CsvSource({ "3, 3, 3, 3, 5,12", "5, 5, 5, 4, 5,20", "2, 2, 2, 2, 5,8", "2, 2, 2, 5, 5,0", "2, 2, 2, 2, 2,8" })
	public void fourOfAKnd(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, FourOfAKind.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3, 4, 5,15", "2, 3, 4, 5, 1,15", "1, 2, 2, 4, 5,0" })
	public void smallStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, SmallStraight.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}

	@ParameterizedTest
	@CsvSource({ "6, 2, 3, 4, 5,20", "2, 3, 4, 5, 6,20", "1, 2, 2, 4, 5,0" })
	public void largeStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, LargeStraight.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}

	@ParameterizedTest
	@CsvSource({ "6, 2, 2, 2, 6,18", "2, 3, 4, 5, 6,0", "1, 1, 2, 2, 2,8", "2, 2, 3, 3, 4,0", "4, 4, 4, 4, 4,0" })
	public void fullHouse(int d1, int d2, int d3, int d4, int d5, int expected) {
		assertEquals(expected, FullHouse.calculateScore(new DiceRoller(d1, d2, d3, d4, d5)));
	}
}
