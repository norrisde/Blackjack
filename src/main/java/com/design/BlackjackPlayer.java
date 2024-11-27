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
		// Win an extra 50% on Blackjacks
		currentBet *= getScore() == 21 ? 2.5 : 2.0;
		System.out.println("+ $" + currentBet);
		money += currentBet;
		currentBet = 0;
		turn = 0;
	}

	public void tie() {
		System.out.println("+ $0");
		money += currentBet; // Return bet
		currentBet = 0;
		turn = 0;
	}

	public void lose() {
		System.out.println("- $" + currentBet);
		currentBet = 0; // Lose bet
		turn = 0;
	}

	@Override
	public void addCard(Card card) {
		System.out.println("You draw: " + card + "!");
		super.addCard(card);
	}

}
