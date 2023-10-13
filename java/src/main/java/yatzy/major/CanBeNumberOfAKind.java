package yatzy.major;

import java.util.Comparator;
import java.util.Map;

import yatzy.Party;

public interface CanBeNumberOfAKind {
	
	default Integer getNumberOfKind(Party party, int kindNumber) {
        return party.getCountsMap().entrySet().stream()
            .filter(e -> e.getValue() >= kindNumber)
            .map(Map.Entry::getKey)
            .max(Comparator.naturalOrder())
            .map(d -> d * kindNumber)
            .orElse(0);
    }

}
