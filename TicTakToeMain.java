package com.blz.tictaktoeproblem;

import java.util.Scanner;

public class TicTakToeMain {
	private static final Scanner SC = new Scanner(System.in);
	// contants
	public static final int HEAD = 0;
	public static final int TAIL = 1;

	public static enum Player {
		USER, COMPUTER
	}

	static char[] board = new char[10];
	static int index;
	static char letter;

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

	// UC-3 Method to print the Board
	private static void displayBoard(char[] board) {
		System.out.println("\n" + board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("_________");
		System.out.println("\n" + board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("_________");
		System.out.println("\n" + board[7] + " | " + board[8] + " | " + board[9]);
	}

	// UC-4 Ability to user to make a move
	private static void getUserMove(char[] board, Scanner userInput) {
		System.out.println("What is your Next Move? (1-9)");
		index = userInput.nextInt();
		System.out.println("Enter the Letter:");
		letter = userInput.next().charAt(0);
	}

	// UC-5 Ability to check if space is free And then make move
	private static void makeMove(char[] board, int index, char letter) {
		if (board[index] == ' ') {
			System.out.println("Enter the Letter:");
			board[index] = letter;
			displayBoard(board);
		} else {
			System.out.println("The position is not free! Please try again");
		}
	}

	// UC-7 Ability to check who starts the game first
	public static Player getWhoPlayFirst() {
		int toss = (int) (Math.floor(Math.random() * 10) % 2);
		return (toss == HEAD) ? Player.USER : Player.COMPUTER;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tak Toe game");

		// Invoking Methods
		board = createBoard();

		char userLetter = chooseUserLetter(SC);
		char computerLetter = (userLetter == 'X') ? 'O' : 'X';
		System.out.println(computerLetter);

		displayBoard(board);

		getUserMove(board, SC);

		makeMove(board, index, letter);

		Player player = getWhoPlayFirst();
		System.out.println("Game will be started by : " + player);
	}
}
