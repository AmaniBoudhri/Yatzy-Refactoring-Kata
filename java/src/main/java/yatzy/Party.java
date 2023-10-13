package yatzy;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;

public abstract class Party {

	protected final List<Integer> dices;

	protected Party(List<Integer> dices) {
		this.dices = dices;
	}

	public Map<Integer, Long> getCountsMap() {
		return dices.stream().collect(groupingBy(identity(), counting()));
	}

	public abstract int calculateScore();

}