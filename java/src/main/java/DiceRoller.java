import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class DiceRoller {
    private static final List<Integer> SMALL_STRAIGHT_LIST = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> LARGEST_STRAIGHT_LIST = List.of(2, 3, 4, 5, 6);
    private final List<Integer> dices;

    public DiceRoller(int d1, int d2, int d3, int d4, int d5) {
        this.dices = List.of(d1, d2, d3, d4, d5);
    }

    public Map<Integer, Long> getCountsMap() {
        return dices.stream()
            .collect(groupingBy(identity(), counting()));
    }

    public int sum() {
        return dices.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public int getDiceNumberCount(int diceNumber) {
        return getCountsMap()
            .getOrDefault(diceNumber, 0L)
            .intValue() * diceNumber;
    }

    public List<Integer> findTwoPairs() {
        return getCountsMap().entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .map(Map.Entry::getKey)
            .collect(toList());
    }

    public Integer getNumberOfKind(Map<Integer, Long> counts, int kindNumber) {
        return counts.entrySet().stream()
            .filter(e -> e.getValue() >= kindNumber)
            .map(Map.Entry::getKey)
            .max(Comparator.naturalOrder())
            .map(d -> d * kindNumber)
            .orElse(0);
    }

    public boolean isSmallStraight() {
        return dices.stream()
            .sorted()
            .collect(toList())
            .equals(SMALL_STRAIGHT_LIST);
    }

    public boolean isLargeStraight() {
        return dices.stream()
            .sorted()
            .collect(toList())
            .equals(LARGEST_STRAIGHT_LIST);
    }
}
