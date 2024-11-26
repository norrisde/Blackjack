package com.design;

import java.util.ArrayList;

public class Deck extends GroupOfCards {

	public Deck() {	
		super(0);	
		initializeDeck();
	}

	/* Set up a standard deck of 52 shuffled playing cards */
	private void initializeDeck() {	
		// Add all combinations of playing card to deck
		this.setCards(new ArrayList<>());
		for (var value : PlayingCard.Suit.values()) {
			for (var suit: PlayingCard.Value.values()) {	
				this.getCards().add(new PlayingCard(suit, value));
			}
		}

		this.shuffle();
		this.setSize(this.getCards().size());
	}
}
