package yatzy;

import java.util.function.Function;

public enum Category {
	Chance(Score::chance), Yatzy(Score::yatzy), Ones(Score::ones), Twos(Score::twos), Threes(Score::threes),
	Fours(Score::fours), Fives(Score::fives), Sixes(Score::sixes), Pair(Score::pair), TwoPairs(Score::twoPairs),
	ThreeOfAKind(Score::threeOfAKind), FourOfAKind(Score::fourOfAKind), SmallStraight(Score::smallStraight),
	LargeStraight(Score::largeStraight), FullHouse(Score::fullHouse);

	private final Function<DiceRoller, Integer> score;

	Category(Function<DiceRoller, Integer> score) {
		this.score = score;
	}

	public int calculateScore(DiceRoller diceRoller) {
		return this.score.apply(diceRoller);
	}

}
