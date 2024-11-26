package com.design;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BlackjackHandTest {

	@Test
	public void testGetHandValue1() {
		BlackjackHand hand = new BlackjackHand();
		hand.add(new PlayingCard(Value.ACE, Suit.HEARTS)); // 11
		hand.add(new PlayingCard(Value.QUEEN, Suit.HEARTS)); // 10
		int value = hand.getHandValue();

		System.out.println(hand);
		assertEquals(value, 21);
	}

	@Test
	public void testGetHandValue2() {
		BlackjackHand hand = new BlackjackHand();
		hand.add(new PlayingCard(Value.ACE, Suit.HEARTS)); // 1
		hand.add(new PlayingCard(Value.ACE, Suit.HEARTS)); // 1
		hand.add(new PlayingCard(Value.QUEEN, Suit.HEARTS)); // 10
		int value = hand.getHandValue();

		System.out.println(hand);
		assertEquals(value, 12);
	}

	@Test
	public void testGetHandValue3() {
		BlackjackHand hand = new BlackjackHand();
		hand.add(new PlayingCard(Value.EIGHT, Suit.HEARTS)); // 1
		hand.add(new PlayingCard(Value.SEVEN, Suit.HEARTS)); // 1
		int value = hand.getHandValue();

		System.out.println(hand);
		assertEquals(value, 15);
	}
}
