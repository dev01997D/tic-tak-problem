package com.blz.tictaktoeproblem;

import java.util.Scanner;

public class TicTakToeMain {
	private static final Scanner SC = new Scanner(System.in);
	static char[] board = new char[10];

	// UC-1 Creating method CreateBoard
	private char[] createBoard() {
		// create board and assign it with empty space
		for (int indexBoard = 0; indexBoard < 10; indexBoard++) {
			if (indexBoard != 0)
				board[indexBoard] = ' ';
		}
		return board;
	}

	// UC-2 method to allow player choose 'X' or 'O'
	private static char chooseUserLetter(Scanner userInput) {
		System.out.println("Choose your Letter : ");
		return userInput.next().toUpperCase().charAt(0);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tak Toe game");
		// Creating object of class
		TicTakToeMain ticObj = new TicTakToeMain();

		// Invoking Methods
		board = ticObj.createBoard();

		char userLetter = chooseUserLetter(SC);
		char computerLetter = (userLetter == 'X') ? 'O' : 'X';
		System.out.println(computerLetter);
	}
}
