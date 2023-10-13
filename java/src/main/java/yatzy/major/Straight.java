package yatzy.major;

import static java.util.stream.Collectors.toList;

import java.util.List;

import yatzy.Category;
import yatzy.Party;

public class Straight extends Party {
	
	protected Category category;
	
	private static final List<Integer> SMALL_STRAIGHT_LIST = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> LARGE_STRAIGHT_LIST = List.of(2, 3, 4, 5, 6);
    
    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;

	public Straight(List<Integer> dices, Category category) {
		super(dices);
		this.category = category;
	}

	@Override
	public int calculateScore() {
		if(isStraight(this.category)) {
			return getScore(this.category);
		}
		return 0;
	}
	
	private boolean isStraight(Category straightCategory) {
        return dices.stream()
            .sorted()
            .collect(toList())
            .equals(getStraight(straightCategory));
    }
	
	private List<Integer> getStraight(Category straightCategory) {
		if(straightCategory.equals(Category.SMALL_STRAIGHT)) {
			return SMALL_STRAIGHT_LIST;
		}
		if(straightCategory.equals(Category.LARGE_STRAIGHT)) {
			return LARGE_STRAIGHT_LIST;
		}
		 throw new IllegalArgumentException("straightCategory must be SMALL_STRAIGHT or LARGE_STRAIGHT");
	}
	
	private int getScore(Category straightCategory) {
		if(straightCategory.equals(Category.SMALL_STRAIGHT)) {
			return SMALL_STRAIGHT_SCORE;
		}
		if(straightCategory.equals(Category.LARGE_STRAIGHT)) {
			return LARGE_STRAIGHT_SCORE;
		}
		throw new IllegalArgumentException("straightCategory must be SMALL_STRAIGHT or LARGE_STRAIGHT");
	}

}
