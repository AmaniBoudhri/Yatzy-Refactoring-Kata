import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.Comparator.reverseOrder;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public class Dices {

    public static final List<Integer> SMALL_STRAIGHT_LIST = List.of(1, 2, 3, 4, 5);
    public static final List<Integer> LARGEST_STRAIGHT_LIST = List.of(2, 3, 4, 5, 6);
    private final List<Integer> dice;

    public Dices(int d1, int d2, int d3, int d4, int d5) {
        this.dice = List.of(d1, d2, d3, d4, d5);
    }

    public Map<Integer, Long> getCountsMap() {
        return dice.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
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

    public int getDiceNumber(Map<Integer, Long> counts, int diceNumber) {
        return ofNullable(counts.get(diceNumber)).orElse(0L)
            .intValue() * diceNumber;
    }

    public Integer getNumberOfKind(Map<Integer, Long> counts, int kindNumber) {
        return counts.entrySet().stream()
            .filter(e -> e.getValue() >= kindNumber)
            .map(Map.Entry::getKey)
            .max(Comparator.naturalOrder())
            .map(d -> d * kindNumber)
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
            .equals(SMALL_STRAIGHT_LIST);
    }

    public boolean isLargeStraight() {
        return dice.stream()
            .sorted()
            .collect(toList())
            .equals(LARGEST_STRAIGHT_LIST);
    }
}
