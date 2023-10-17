package yatzy;

import static java.util.stream.Collectors.counting;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Party {

	protected final List<Dice> dices;

	protected Party(List<Dice> dices) {
		this.dices = dices;
	}

	/**
	 * Return every dice value recurrence of the party
	 * 
	 * @return
	 */
	public Map<Integer, Long> getCountsMap() {
		return dices.stream().collect(Collectors.groupingByConcurrent(Dice::getValue, counting()));
	}

	public abstract int calculateScore();

}