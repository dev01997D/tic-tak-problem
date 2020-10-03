package com.blz.tictaktoeproblem;

public class TicTakToeMain {
       //Creating method CreateBoard
  	private void createBoard() {
		// create board and assign it with empty space
		char[] board = new char[10];
		for (int indexBoard = 0; indexBoard < 10; indexBoard++) {
			if (indexBoard != 0)
				board[indexBoard] = ' ';
		}
	}
	
	public static void main(String[] args) {
		// Creating object of class
		TicTakToeMain ticObj = new TicTakToeMain();

		// Invoking createBoard Method
		ticObj.createBoard();
	}
}
