package com.design;

public abstract class AbstractBlackjackPlayer extends Player {

	private BlackjackHand hand;

	public AbstractBlackjackPlayer(String name) {
		super(name);
		this.hand = new BlackjackHand();
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public int getScore() {
		return hand.getHandValue();
	}

	public BlackjackHand getHand() {
		return hand;
	}

}

