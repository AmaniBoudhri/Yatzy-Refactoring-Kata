package yatzy.major;

import yatzy.Party;

public interface CanBeYatzi {
	
	default boolean isYatzi(Party party) {		
		return party.getCountsMap()
	            .entrySet()
	            .stream()
	            .anyMatch(e -> e.getValue() == 5);
	}

}
