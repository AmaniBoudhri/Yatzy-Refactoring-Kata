package yatzy.major;

import java.util.List;

import yatzy.Party;

public class TwoPairs extends Party implements CanHaveTwoPairs{

	public TwoPairs(List<Integer> dices) {
		super(dices);
	}

	@Override
	public int calculateScore() {
		List<Integer> pairs = findTwoPairs(this);
        if (hasAtLeastTwoPairs(pairs)) {
            return pairs.stream()
                .mapToInt(pair -> pair * 2)
                .sum();
        }
        return 0;
	}

    private static boolean hasAtLeastTwoPairs(List<Integer> pairs) {
        return pairs.size() >= 2;
    }

}
