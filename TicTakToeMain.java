package com.blz.tictaktoeproblem;

import java.util.Scanner;

public class TicTakToeMain {
	private static final Scanner SC = new Scanner(System.in);
	static char[] board = new char[10];

	// UC-1 Creating method CreateBoard
	private static char[] createBoard() {
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

	//	UC-3 Method to print the Board
	private static void displayBoard(char[] board) {
		System.out.println("\n" + board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("_________");
		System.out.println("\n" + board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("_________");
		System.out.println("\n" + board[7] + " | " + board[8] + " | " + board[9]);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tak Toe game");

		// Invoking Methods
		board = createBoard();

		char userLetter = chooseUserLetter(SC);
		char computerLetter = (userLetter == 'X') ? 'O' : 'X';
		System.out.println(computerLetter);

		displayBoard(board);
	}
}