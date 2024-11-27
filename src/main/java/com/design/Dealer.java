package com.design;

public class Dealer extends AbstractBlackjackPlayer {

	public Dealer() {
		super("Dealer");
	}

	@Override
	public GameAction play() {
		if (getScore() < 17) {
			System.out.println("Dealer hits.");
			return GameAction.HIT;
		}

		System.out.println("Dealer stands.");
		return GameAction.STAND;
	}
}
