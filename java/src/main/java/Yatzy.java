import java.util.List;

import static java.util.Optional.ofNullable;

public class Yatzy {

    public static int chance(Dices dices) {
        return dices.sum();
    }

    public static int yatzy(Dices dices) {
        if (dices.isYatzy()) {
            return 50;
        }
        return 0;
    }

    public static int ones(Dices dices) {
        return ofNullable(dices.getCountsMap().get(1)).orElse(0L).intValue();
    }

    public static int twos(Dices dices) {
        return dices.getDiceNumber(dices.getCountsMap(), 2);
    }

    public static int threes(Dices dices) {
        return dices.getDiceNumber(dices.getCountsMap(), 3);
    }

    public static int fours(Dices dices) {
        return dices.getDiceNumber(dices.getCountsMap(), 4);
    }

    public static int fives(Dices dices) {
        return dices.getDiceNumber(dices.getCountsMap(), 5);
    }

    public static int sixes(Dices dices) {
        return dices.getDiceNumber(dices.getCountsMap(), 6);
    }

    public static int onePair(Dices dices) {
        return dices.getNumberOfKind(dices.getCountsMap(), 2);
    }

    public static int twoPair(Dices dices) {
        List<Integer> pairs = dices.findTwoPairs();
        if (pairs.size() >= 2) {
            return pairs.stream()
                .mapToInt(pair -> pair * 2)
                .sum();
        }
        return 0;
    }

    public static int threeOfAKind(Dices dices) {
        return dices.getNumberOfKind(dices.getCountsMap(), 3);
    }

    public static int fourOfAKind(Dices dices) {
        return dices.getNumberOfKind(dices.getCountsMap(), 4);
    }

    public static int smallStraight(Dices dices) {

        if (dices.isSmallStraight()) {
            return 15;
        }
        return 0;
    }

    public static int largeStraight(Dices dices) {
        if (dices.isLargeStraight()) {
            return 20;
        }
        return 0;
    }

    public static int fullHouse(Dices dices) {

        if (dices.getNumberOfKind(dices.getCountsMap(), 3) != 0 && !dices.findTwoPairs().isEmpty() && !dices.isYatzy()) {
            return dices.sum();
        }
        return 0;
    }
}



