package com.blz.tictaktoeproblem;

import java.util.Scanner;

public class TicTakToeMain {
	private static final Scanner SC = new Scanner(System.in);
	// Contants
	public static final int HEAD = 0;
	public static final int TAIL = 1;

	// variables
	static char userLetter;
	static char compLetter;

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

	// UC-4 Ability to user to provide a move
	private static int getUserMove(char[] board) {
		System.out.println("What is your Next Move? (1-9)");
		int localIndex = SC.nextInt();
		return localIndex;
	}

	// UC-5 Ability to check if space is free And then make move
	private static void makeUserMove(char[] board, char letterInput) {
		boolean isFree = true;
		while (isFree) {
			int localIndex = getUserMove(board);
			if (board[localIndex] == ' ') {
				board[localIndex] = letterInput;
				displayBoard(board);
				isFree = false;
			} else {
				System.out.println("The position is not free! Please try again");
			}
		}
	}

	// UC-6 Ability to check who starts the game first
	public static Player getWhoPlayFirst() {
		int toss = (int) (Math.floor(Math.random() * 10) % 2);
		return (toss == HEAD) ? Player.USER : Player.COMPUTER;
	}

	// UC-7 Ability to check if Someone Won
	public static boolean isWinner(char[] b, char pc, char user) {
		if ((b[1] == user && b[2] == user && b[3] == user) || (b[4] == user && b[5] == user && b[6] == user)
				|| (b[7] == user && b[8] == user && b[9] == user) || (b[1] == user && b[4] == user && b[7] == user)
				|| (b[2] == user && b[5] == user && b[8] == user) || (b[3] == user && b[6] == user && b[9] == user)
				|| (b[1] == user && b[5] == user && b[9] == user) || (b[3] == user && b[5] == user && b[7] == user)) {
			System.out.println("User is the Winner. \nThank You for playing the Game");
			return true;
		} else if ((b[1] == pc && b[2] == pc && b[3] == pc) || (b[4] == pc && b[5] == pc && b[6] == pc)
				|| (b[7] == pc && b[8] == pc && b[9] == pc) || (b[1] == pc && b[4] == pc && b[7] == pc)
				|| (b[2] == pc && b[5] == pc && b[8] == pc) || (b[3] == pc && b[6] == pc && b[9] == pc)
				|| (b[1] == pc && b[5] == pc && b[9] == pc) || (b[3] == pc && b[5] == pc && b[7] == pc)) {
			System.out.println("Computer is the Winner. \nThank You for playing the Game");
			return true;
		} else
			return false;
	}

	// UC-8 & UC-9 Smart move by computer on its turn
	public static int smartMoveByComputer(char[] b, char cLetter, char uLetter) {
		int flag = 0;
		String line1 = uLetter + "" + uLetter + "";
		String line2 = cLetter + "" + cLetter + "";
		for (int check = 1; check <= 9; check++) {
			if (((b[2] + "" + b[3] + "").equals(line2) || (b[5] + "" + b[9]).equals(line2)
					|| (b[4] + "" + b[7] + "").equals(line2))
					|| ((b[2] + "" + b[3] + "").equals(line1) || (b[5] + "" + b[9] + "").equals(line1)
							|| (b[4] + "" + b[7] + "").equals(line1))) {
				if (b[1] == ' ') {
					b[1] = cLetter;
					flag = 1;
				}
				flag = 1;
			}

			else if (((b[1] + "" + b[3] + "").equals(line2) || (b[5] + "" + b[8] + "").equals(line2))
					|| ((b[1] + "" + b[3] + "").equals(line1) || (b[5] + "" + b[8] + "").equals(line1))) {
				if (b[2] == ' ') {
					b[2] = cLetter;
					flag = 1;
				}
			}

			else if (((b[2] + "" + b[1] + "").equals(line2) || (b[6] + "" + b[9] + "").equals(line2)
					|| (b[5] + "" + b[7] + "" == line2))
					|| ((b[1] + "" + b[2] + "").equals(line1) || (b[6] + "" + b[9] + "").equals(line1)
							|| (b[5] + "" + b[7] + "" == line1))) {
				if (b[3] == ' ') {
					b[3] = cLetter;
					flag = 1;
				}
			}

			else if (((b[1] + "" + b[7] + "").equals(line2) || (b[5] + "" + b[6] + "").equals(line2))
					|| ((b[1] + "" + b[7] + "").equals(line1) || (b[5] + "" + b[6] + "").equals(line1))) {
				if (b[4] == ' ') {
					b[4] = cLetter;
					flag = 1;
				}
			} else if (((b[1] + "" + b[9] + "").equals(line2) || (b[4] + "" + b[6] + "").equals(line2)
					|| (b[2] + "" + b[8] + "").equals(line2) || (b[3] + "" + b[7] + "").equals(line2))
					|| ((b[1] + "" + b[9] + "").equals(line1) || (b[4] + "" + b[6] + "").equals(line1)
							|| (b[2] + "" + b[8] + "").equals(line1) || (b[3] + "" + b[7] + "").equals(line1))) {
				if (b[5] == ' ') {
					b[5] = cLetter;
					flag = 1;
				}
			}

			else if (((b[3] + "" + b[9] + "").equals(line2) || (b[4] + "" + b[5] + "").equals(line2))
					|| ((b[3] + "" + b[9] + "").equals(line1) || (b[4] + "" + b[5] + "").equals(line1))) {
				if (b[6] == ' ') {
					b[6] = cLetter;
					flag = 1;
				}
			}

			else if (((b[1] + "" + b[4] + "").equals(line2) || (b[8] + "" + b[9] + "").equals(line2)
					|| (b[3] + "" + b[5] + "" == line2))
					|| ((b[1] + "" + b[4] + "").equals(line1) || (b[8] + "" + b[9] + "").equals(line1)
							|| (b[3] + "" + b[5] + "").equals(line1))) {
				if (b[7] == ' ') {
					b[7] = cLetter;
					flag = 1;
				}
			}

			else if (((b[7] + "" + b[9] + "").equals(line2) || (b[2] + "" + b[5] + "").equals(line2))
					|| ((b[7] + "" + b[9] + "").equals(line1) || (b[2] + "" + b[5] + "").equals(line1))) {
				if (b[8] == ' ') {
					b[8] = cLetter;
					flag = 1;
				}
			}

			else if (((b[7] + "" + b[8] + "").equals(line2) || (b[1] + "" + b[5] + "").equals(line2)
					|| (b[3] + "" + b[6] + "" == line2))
					|| ((b[7] + "" + b[8] + "").equals(line1) || (b[1] + "" + b[5] + "").equals(line1)
							|| (b[3] + "" + b[6] + "").equals(line1))) {
				if (b[9] == ' ') {
					b[9] = cLetter;
					flag = 1;
				}
			}
			if (flag == 1)
				break;
		}
		if (flag == 1)
			displayBoard(b);
		return flag;
	}

	// UC-10:Ability to take corners & UC-11: Ability to take center and any other
	// position subsequently
	public static void smartMoveByPcIfNoOneIsWinning() {
		System.out.println();
		int flag = smartMoveByComputer(board, compLetter, userLetter);
		while (flag != 1) {
			int position = (int) (Math.floor(Math.random() * 10) % 9);
			if (board[1] == ' ') {
				board[1] = compLetter;
				flag = 1;
			} else if (board[3] == ' ') {
				board[3] = compLetter;
				flag = 1;
			} else if (board[5] == ' ') {
				board[5] = compLetter;
				flag = 1;
			} else if (board[7] == ' ') {
				board[7] = compLetter;
				flag = 1;
			} else if (board[9] == ' ') {
				board[9] = compLetter;
				flag = 1;
			} else {
				if (position>0 && board[position] == ' ') {
					board[position] = compLetter;
					flag = 1;
				} else
					flag = 0;
			}
			displayBoard(board);
		}
	}

	// UC-12: Game continues until win or draw happen
	public static void playTillGameWinOrOver() {
		boolean winCheck = false;
		int i = 1;
		while (winCheck == false && i <= 9) {
			System.out.println();
			switch (i) {
			case 1:
				makeUserMove(board, userLetter);
				break;
			case 2:
				smartMoveByPcIfNoOneIsWinning();
				break;
			case 3:
				makeUserMove(board, userLetter);
				break;
			case 4:
				smartMoveByPcIfNoOneIsWinning();
				break;
			case 5:
				makeUserMove(board, userLetter);
				break;
			case 6:
				smartMoveByPcIfNoOneIsWinning();
				break;
			case 7:
				makeUserMove(board, userLetter);
				break;
			case 8:
				smartMoveByPcIfNoOneIsWinning();
				break;
			default:
				makeUserMove(board, userLetter);
				break;
			}
			i++;
			winCheck = isWinner(board, compLetter, userLetter);
			if (winCheck == false)
				System.out.println("None has won game, Please enter next move");
			if (i > 9 && winCheck == false)
				System.out.println("Draw Occurs");
		}
	}

	// uc-13 Play another game
	public static void playAnotherGame() {
		System.out.println("Do you want to play Another new Game");
		char reply = SC.next().charAt(0);
		if ((reply + "").equalsIgnoreCase("Y")) {
			board = createBoard();
			userLetter = chooseUserLetter(SC);
			compLetter = (userLetter == 'X') ? 'O' : 'X';
			System.out.println("Computer letter is : " + compLetter);
			displayBoard(board);
			playTillGameWinOrOver();
		} else {
			System.out.println("Thank you!");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tak Toe game");

		// Invoking Methods
		board = createBoard();

		Player player = getWhoPlayFirst();
		System.out.println("Game will be started by : " + player);

		userLetter = chooseUserLetter(SC);
		compLetter = (userLetter == 'X') ? 'O' : 'X';
		System.out.println("Computer letter is : " + compLetter);

		displayBoard(board);
		playTillGameWinOrOver();
		
		playAnotherGame();
	}
}
