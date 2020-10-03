package com.blz.tictaktoeproblem;

import java.util.Scanner;

public class TicTakToeMain {
	private static Scanner sc = new Scanner(System.in);

	// Creating method CreateBoard
	private char[] createBoard() {
		// create board and assign it with empty space
		char[] board = new char[10];
		for (int indexBoard = 0; indexBoard < 10; indexBoard++) {
			if (indexBoard != 0)
				board[indexBoard] = ' ';
		}
		return board;
	}

	// method to allow player choose 'X' or 'O'
	private char allowPlayerChooseOption(char userOption) {
		char computerOption;
		if (userOption == 'O')
			computerOption = 'X';
		else
			computerOption = 'O';
		System.out.println("Computer option is : " + computerOption + "\n");
		return computerOption;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tak Toe game");
		// Creating object of class
		TicTakToeMain ticObj = new TicTakToeMain();

		// Invoking createBoard Method
		char board[] = ticObj.createBoard();

		// Invoking allowChooseOptionMethod
		System.out.println("Enter the option 'X' or 'O'");
		char option = sc.next().charAt(0);
		ticObj.allowPlayerChooseOption(option);
	}
}
