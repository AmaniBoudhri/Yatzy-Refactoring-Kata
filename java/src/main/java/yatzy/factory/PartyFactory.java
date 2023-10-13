package yatzy.factory;

import java.util.List;

import yatzy.CategoryEnum;
import yatzy.Party;
import yatzy.minor.Minor;

public class PartyFactory {

	private List<Integer> dices;

	public PartyFactory(int d1, int d2, int d3, int d4, int d5) {
		this.dices = List.of(d1, d2, d3, d4, d5);
	}

	public Party createParty(CategoryEnum category) {
		if (category.equals(CategoryEnum.ONES)) {
			return new Minor(this.dices, 1);
		}
		if (category.equals(CategoryEnum.TWOS)) {
			return new Minor(this.dices, 2);
		}
		if (category.equals(CategoryEnum.THREES)) {
			return new Minor(this.dices, 3);
		}
		if (category.equals(CategoryEnum.FOURS)) {
			return new Minor(this.dices, 4);
		}
		if (category.equals(CategoryEnum.FIVES)) {
			return new Minor(this.dices, 5);
		}
		if (category.equals(CategoryEnum.SIXES)) {
			return new Minor(this.dices, 6);
		}
		return null;
	}

}