package yatzy.minor;

import java.util.List;

import yatzy.Party;

public class Minor extends Party {

	protected int diceNumber;

	public Minor(List<Integer> dices, int diceNumber) {
		super(dices);
		this.diceNumber = diceNumber;
	}

	/**
	 * Get recurrence number of this.diceNumber
	 * 
	 * @return
	 */
	private int getDiceNumberCount() {
		return getCountsMap().getOrDefault(this.diceNumber, 0L).intValue() * this.diceNumber;
	}

	@Override
	public int calculateScore() {
		return getDiceNumberCount();
	}

}