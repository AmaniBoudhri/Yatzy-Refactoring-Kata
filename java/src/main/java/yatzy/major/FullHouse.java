package yatzy.major;

import java.util.List;

import yatzy.Party;

public class FullHouse extends Party implements CanBeNumberOfAKind, CanBeYatzi, CanHaveTwoPairs {

	public FullHouse(List<Integer> dices) {
		super(dices);
	}
	
	private boolean isAfullHouse() {
        return getNumberOfKind(this, 3) != 0 && !findTwoPairs(this).isEmpty() && !isYatzi(this);
    }

	@Override
	public int calculateScore() {
		if (isAfullHouse()) {
            return this.dices.stream()
    	            .mapToInt(Integer::intValue)
    	            .sum();
        }
        return 0;
	}

}
