import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public class Yatzy {

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);
        return counts.entrySet().stream().filter(e -> e.getValue() == 5)
            .findFirst()
            .map(e -> 50)
            .orElse(0);
    }

    private static Map<Integer, Long> getCountsMap(int d1, int d2, int d3, int d4, int d5) {
        return Stream.of(d1, d2, d3, d4, d5)
            .collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);
        return Optional.ofNullable(counts.get(1)).orElse(0L).intValue();
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);
        return getDiceNumber(counts, 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);
        return getDiceNumber(counts, 3);
    }

    public static int fours(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);
        return getDiceNumber(counts, 4);
    }

    public static int fives(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);
        return getDiceNumber(counts, 5);
    }

    public static int sixes(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);
        return getDiceNumber(counts, 6);
    }

    private static int getDiceNumber(Map<Integer, Long> counts, int i) {
        return Optional.ofNullable(counts.get(i)).orElse(0L).intValue() * i;
    }

    public static int onePair(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);

        return getNumberOfKind(counts, 2);
    }

    public static int twoPair(int d1, int d2, int d3, int d4, int d5) {
        List<Integer> pairs = getCountsMap(d1, d2, d3, d4, d5).entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .map(Map.Entry::getKey)
            .sorted(reverseOrder())
            .collect(toList());
        if (pairs.size() >= 2) {
            return pairs.stream()
                .mapToInt(pair -> pair * 2)
                .sum();
        }
        return 0;
    }

    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);

        return getNumberOfKind(counts, 3);
    }

    private static Integer getNumberOfKind(Map<Integer, Long> counts, int i) {
        return counts.entrySet().stream()
            .filter(e -> e.getValue() >= i)
            .map(Map.Entry::getKey)
            .max(Comparator.naturalOrder())
            .map(d -> d * i)
            .orElse(0);
    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Long> counts = getCountsMap(d1, d2, d3, d4, d5);
        return getNumberOfKind(counts, 4);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {

        if (isSmallOrLarge(d1, d2, d3, d4, d5, 1, 2, 3, 4, 5)) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        if (isSmallOrLarge(d1, d2, d3, d4, d5, 2, 3, 4, 5, 6)) {
            return 20;
        }
        return 0;
    }

    private static boolean isSmallOrLarge(int d1, int d2, int d3, int d4, int d5, int i, int i2, int i3, int i4, int i5) {
        return Stream.of(d1, d2, d3, d4, d5)
            .sorted().collect(toList())
            .equals(asList(i, i2, i3, i4, i5));
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[d1 - 1] += 1;
        tallies[d2 - 1] += 1;
        tallies[d3 - 1] += 1;
        tallies[d4 - 1] += 1;
        tallies[d5 - 1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }

        if (_2 && _3) {
            return _2_at * 2 + _3_at * 3;
        } else {
            return 0;
        }
    }
}



