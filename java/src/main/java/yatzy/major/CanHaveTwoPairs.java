package yatzy.major;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import yatzy.Party;

public interface CanHaveTwoPairs {
	
	default List<Integer> findTwoPairs(Party party) {
        return party.getCountsMap().entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .map(Map.Entry::getKey)
            .collect(toList());
    }

}
