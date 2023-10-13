package yatzy.major;

import java.util.List;

import yatzy.Party;

public class Chance extends Party {

	public Chance(List<Integer> dices) {
		super(dices);
	}

	@Override
	public int calculateScore() {
		return this.dices.stream()
	            .mapToInt(Integer::intValue)
	            .sum();
	}

}
