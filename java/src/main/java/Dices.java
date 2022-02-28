import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public class Dices {

    private final List<Integer> dice;

    public Dices(int d1, int d2, int d3, int d4, int d5) {
        this.dice = asList(d1, d2, d3, d4, d5);
    }

    public Map<Integer, Long> getCountsMap() {
        return dice.stream()
            .collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }

    public int sum() {
        return dice.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public boolean isYatzy() {
        return getCountsMap()
            .entrySet()
            .stream()
            .anyMatch(e -> e.getValue() == 5);
    }

    public int getDiceNumber(Map<Integer, Long> counts, int i) {
        return ofNullable(counts.get(i)).orElse(0L)
            .intValue() * i;
    }

    public Integer getNumberOfKind(Map<Integer, Long> counts, int i) {
        return counts.entrySet().stream()
            .filter(e -> e.getValue() >= i)
            .map(Map.Entry::getKey)
            .max(Comparator.naturalOrder())
            .map(d -> d * i)
            .orElse(0);
    }

    public List<Integer> findTwoPairs() {
        return getCountsMap().entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .map(Map.Entry::getKey)
            .sorted(reverseOrder())
            .collect(toList());
    }

    public boolean isSmallStraight() {
        return dice.stream()
            .sorted()
            .collect(toList())
            .equals(asList(1, 2, 3, 4, 5));
    }

    public boolean isLargeStraight() {
        return dice.stream()
            .sorted()
            .collect(toList())
            .equals(asList(2, 3, 4, 5, 6));
    }
}
