package com.design;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayingCardTest {

	@Test
	public void testToString() {
		System.out.println("Testing PlayingCard::toString");
		PlayingCard card = new PlayingCard(PlayingCard.Value.QUEEN, PlayingCard.Suit.HEARTS);

		String result = card.toString();
		System.out.println("Result: " + result);

		assertEquals(result, "Queen of Hearts");
	}
}
