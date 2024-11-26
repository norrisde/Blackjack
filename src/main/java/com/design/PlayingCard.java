package com.design;

public class PlayingCard extends Card {

	private Value value;
	private Suit suit;

	public PlayingCard(Value value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return toUpperFirstChar(value.toString()) + " of " + toUpperFirstChar(suit.toString());
	}

	private String toUpperFirstChar(String string) {
		return Character.toUpperCase(string.charAt(0)) + string.toLowerCase().substring(1);
	}

	public Value getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}
}
