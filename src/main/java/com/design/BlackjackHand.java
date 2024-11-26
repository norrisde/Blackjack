package com.design;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BlackjackHand extends GroupOfCards {

	public BlackjackHand() {
		super(0);
		this.setCards(new ArrayList<>());
	}

	@Override
	public String toString() {
		return "Hand (" + this.getHandValue() + "): " + this.getCards().stream()
			.map(c -> String.format("(%s)", c))
			.collect(Collectors.joining(" "));
	}

	public void add(Card card) {
		this.getCards().add(card);
	}

	public int getHandValue() {
		int value = 0;
		int aces = 0; // Number of aces;

		// Count aces, add other cards to value immediately
		for (Card c : this.getCards()) {
			PlayingCard card = (PlayingCard) c;
			if (card.getValue() == Value.ACE) {
				aces++;
				continue;
			}
			value += card.getValue().getValue();
		}

		value += aces; // At a minimum, all aces add +1 to hand value
		for (int i = 0; i < aces; i++) {
			// If treating an Ace value as 11 (+10 value) won't make score go over 21, do so
			if (value <= 11) {
				value += 10;
			}
		}
		return value;
	}
}
