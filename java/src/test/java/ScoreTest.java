import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import yatzy.Category;
import yatzy.Dice;
import yatzy.Party;
import yatzy.factory.PartyFactory;

class ScoreTest {

	@ParameterizedTest
	@CsvSource({ "2, 3, 4, 5, 1,15", "3, 3, 4, 5, 1,16", "1, 1, 3, 3, 6,14", "4, 5, 5, 6, 1,21" })
	void chance(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party chance = factory.createParty(Category.CHANCE);
		assertEquals(expected, chance.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "4, 4, 4, 4, 4,50", "6, 6, 6, 6, 6,50", "6, 6, 6, 6, 3,0", "1, 1, 1, 1, 1,50", "1, 1, 1, 2, 1,0" })
	void yatzy(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party yatzi = factory.createParty(Category.YATZI);
		assertEquals(expected, yatzi.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3, 4, 5,1", "1, 2, 1, 4, 5,2", "6, 2, 2, 4, 5,0", "1, 2, 1, 1, 1,4", "3, 3, 3, 4, 5,0" })
	void ones(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party ones = factory.createParty(Category.ONES);
		assertEquals(expected, ones.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3, 2, 6,4", "2, 2, 2, 2, 2,10", "2, 3, 2, 5, 1,4" })
	void twos(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party twos = factory.createParty(Category.TWOS);
		assertEquals(expected, twos.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3, 2, 3,6", "2, 3, 3, 3, 3,12" })
	void threes(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party threes = factory.createParty(Category.THREES);
		assertEquals(expected, threes.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "4, 4, 4, 5, 5,12", "4, 4, 5, 5, 5,8", "4, 5, 5, 5, 5,4", "1, 1, 2, 4, 4,8" })
	void fours(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party fours = factory.createParty(Category.FOURS);
		assertEquals(expected, fours.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "4, 4, 4, 5, 5,10", "4, 4, 5, 5, 5,15", "4, 5, 5, 5, 5,20" })
	void fives(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party fives = factory.createParty(Category.FIVES);
		assertEquals(expected, fives.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "4, 4, 4, 5, 5,0", "4, 4, 6, 5, 5,6", "6, 5, 6, 6, 5,18" })
	void sixes(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party sixes = factory.createParty(Category.SIXES);
		assertEquals(expected, sixes.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "3, 4, 3, 5, 6,6", "5, 3, 3, 3, 5,10", "5, 3, 6, 6, 5,12", "3, 3, 3, 4, 4,8", "1, 1, 6, 2, 6,12",
			"3, 3, 3, 4, 1,6", "3, 3, 3, 3, 1,6" })
	void pair(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party pair = factory.createParty(Category.PAIR);
		assertEquals(expected, pair.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "3, 3, 5, 4, 5,16", "3, 3, 5, 5, 5,16", "1, 1, 2, 3, 3,8", "1, 1, 2, 3, 4,0", "1, 1, 2, 2, 2,6" })
	void twoPair(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party twoPairs = factory.createParty(Category.TWO_PAIRS);
		assertEquals(expected, twoPairs.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "3, 3, 3, 4, 5,9", "5, 3, 5, 4, 5,15", "3, 3, 3, 3, 5,9", "3, 3, 3, 3, 3,9", "3, 3, 4, 5, 6,0",
			"3, 3, 3, 3, 1,9" })
	void threeOfAKind(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party threeOfAKind = factory.createParty(Category.THREE_OF_A_KIND);
		assertEquals(expected, threeOfAKind.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "3, 3, 3, 3, 5,12", "5, 5, 5, 4, 5,20", "2, 2, 2, 2, 5,8", "2, 2, 2, 5, 5,0", "2, 2, 2, 2, 2,8" })
	void fourOfAKind(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party fourOfAKind = factory.createParty(Category.FOUR_OF_A_KIND);
		assertEquals(expected, fourOfAKind.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3, 4, 5,15", "2, 3, 4, 5, 1,15", "1, 2, 2, 4, 5,0" })
	void smallStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party smallStraight = factory.createParty(Category.SMALL_STRAIGHT);
		assertEquals(expected, smallStraight.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "6, 2, 3, 4, 5,20", "2, 3, 4, 5, 6,20", "1, 2, 2, 4, 5,0" })
	void largeStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party largeStraight = factory.createParty(Category.LARGE_STRAIGHT);
		assertEquals(expected, largeStraight.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "6, 2, 2, 2, 6,18", "2, 3, 4, 5, 6,0", "1, 1, 2, 2, 2,8", "2, 2, 3, 3, 4,0", "4, 4, 4, 4, 4,0" })
	void fullHouse(int d1, int d2, int d3, int d4, int d5, int expected) {
		PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4), new Dice(d5));
		Party fullHouse = factory.createParty(Category.FULL_HOUSE);
		assertEquals(expected, fullHouse.calculateScore());
	}

	@ParameterizedTest
	@CsvSource({ "10, 2, 3, 4, 5,1", "1, 20, 1, 4, 5,2", "6, 2, 2, -4, 5,0", "1, 2, 1, 10, 1,4", "3, 3, -3, 4, 5,0" })
	void onesDiceValueException(int d1, int d2, int d3, int d4, int d5, int expected) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			PartyFactory factory = new PartyFactory(new Dice(d1), new Dice(d2), new Dice(d3), new Dice(d4),
					new Dice(d5));
			Party ones = factory.createParty(Category.ONES);
			ones.calculateScore();
		});
		assertTrue(exception.getMessage().contains("Invalid dice value! Value should between 1 and 6!"));
	}
}
