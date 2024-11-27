package com.design;

import java.util.Scanner;

public class BlackjackPlayer extends AbstractBlackjackPlayer {

	private int money;
	private int currentBet;
	private int turn = 0;
	private Scanner scanner;

	public BlackjackPlayer(int money) {
		super("Player");
		this.money = money;
		this.scanner = new Scanner(System.in);
	}

	public void chooseBet() {
		while(true) {
			System.out.printf("Current money: %d, Choose an initial bet: $", money);
			int bet;
			try {
				bet = Integer.parseInt(scanner.nextLine());
			} catch(Exception e) {
				System.out.println("Invalid input.");
				continue;
			}

			if (bet > money) {
				System.out.println("Not enough money.");
				continue;
			}

			if (bet <= 0) {
				System.out.println("Bet must be a positive integer.");
				continue;
			}

			System.out.println("Set current bet: $" + bet);
			currentBet = bet;
			money -= bet;
			break;
		}
	}

	public void showStatus() {
		System.out.printf("Current money: $%d, Current bet: $%d,  (Turn %d)\n", money, currentBet, turn);
		System.out.println(getHand());
	}

	@Override
	public GameAction play() {
		turn++;
		if (getScore() >= 21) {
			return GameAction.STAND;
		}
		showStatus();

		String actions = "HIT STAND" + (turn == 1 ? " DOUBLE" : "");
		System.out.println("Choose: " + actions);

		while (true) { // Loop until valid input is given
			String input = scanner.nextLine().trim().toUpperCase();
			try {
				GameAction action = GameAction.valueOf(input);

				if (action == GameAction.DOUBLE && currentBet > money) {
					System.out.println("Not enough money. Choose: " + actions);
					continue;
				}

				return action;

			} catch (IllegalArgumentException e) {
				System.out.println("Invalid action. Choose: " + actions);
			}
		}
	}

	public void doubleBet() {
		int current = currentBet;
		currentBet *= 2;
		money -= current;
	}

	public void win() {
		int score = getScore();
		if (score == 21) { // Win an extra 50% on Blackjacks
			System.out.println("Won $" + currentBet +  "! (Blackjack x2.5)");
			currentBet *= 2.5;
		} else {
			System.out.println("Won $" + currentBet +  "!");
			currentBet *= 2;
		}

		money += currentBet;
		currentBet = 0;
		turn = 0;
	}

	public void tie() {
		System.out.println("Bet returned. ($" + currentBet + ")");
		money += currentBet; // Return bet
		currentBet = 0;
		turn = 0;
	}

	public void lose() {
		System.out.println("Bet lost. ($" + currentBet + ")");
		currentBet = 0; // Lose bet
		turn = 0;
	}

	@Override
	public void addCard(Card card) {
		System.out.println("You draw: " + card + "!");
		super.addCard(card);
	}

}
