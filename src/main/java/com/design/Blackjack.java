/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.design;

/**
 *
 * @author melchior
 */
public class Blackjack {

	public static void main(String[] args) {
		Blackjack.runGame();
	}

	public static void runGame() {
		int initialPlayerMoney = 1000;

		BlackjackGame game = new BlackjackGame(initialPlayerMoney);
		game.play();

		while (game.getPlayer().getMoney() > 0 && game.getPlayer().wantsToContinue()) {
			System.out.println("\n\n\nNEW ROUND\n");
			game.play();
		}

		game.over();
	}
}
