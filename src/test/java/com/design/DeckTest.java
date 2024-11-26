package com.design;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeckTest {
	@Test
	public void testNewDeckSize() {
		System.out.println("Testing new Deck");
		Deck deck = new Deck();
		int size = deck.getSize();
		System.out.println("Deck size: " + size);
		assertEquals(size, 52);
	}
}
