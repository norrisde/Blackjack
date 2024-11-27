package com.design;

public class BlackjackGame extends Game {

	private Deck deck;
	private BlackjackPlayer player;
	private Dealer dealer;
	private String winnerName;

	public BlackjackGame(int initialPlayerMoney) {
		super("Blackjack");

		player = new BlackjackPlayer(initialPlayerMoney);
		dealer = new Dealer();
	}

	@Override
	public void play() {
		AbstractBlackjackPlayer[] players = { player, dealer };
		deck = new Deck();
		player.reset();
		dealer.reset();

		player.chooseBet();

		// Both players start with 2 cards.
		delay();
		for (int i = 0; i < 2; i++) {
			player.addCard(deck.draw());
			dealer.addCard(deck.draw());
			delay();
		}

		while (true) {
			int stands = 0; // When both players stand the round is over.

			for (var participant : players) {
				GameAction action = participant.play();
				switch (action) {
					case DOUBLE -> ((BlackjackPlayer) participant).doubleBet();
					case HIT -> participant.addCard(deck.draw());
					case STAND -> stands++;
				}
				delay();
			}

			if (stands == players.length) {
				handleScores();
				declareWinner();
				return;
			}
		}
	}

	// Used to slow down outgoing chat messages so they aren't overwhelming
	public void delay() {
		System.out.println();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void handleScores() {
		int pScore = player.getScore();
		int dScore = dealer.getScore();

		if (pScore > 21) { // Player loses
			player.lose();
			winnerName = dealer.getName();
			return;
		}

		if (dScore > 21) { // Dealer loser
			player.win();
			winnerName = player.getName();
			return;
		}

		if (pScore == dScore) { // Tie
			player.tie();
			winnerName = "Nobody";
			return;
		}

		if (pScore > dScore) { // Player win
			player.win();
			winnerName = player.getName();
			return;
		}

		// Dealer wins
		player.lose();
		winnerName = dealer.getName();
	}

	@Override
	public void declareWinner() {
		System.out.println("Player " + player.getHand());
		System.out.println("Dealer " + dealer.getHand());
		System.out.println(winnerName + " wins the game!");
	}

	public void over() {
		System.out.println("GAME OVER");
		System.out.println("You ended with $" + player.getMoney());
	}

	public BlackjackPlayer getPlayer() {
		return player;
	}
}
