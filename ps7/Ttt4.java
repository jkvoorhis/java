//October 17, 2012 update: asks if want to play again after
//a game and then restarts

import java.util.Scanner;

/* A board is a 3x3 grid, the squares of the grid are numbered 1 through 9, as indicated below.
 *
 *    |   |
 *  1 | 2 | 3
 *    |   |
 * ---+---+---
 *    |   |
 *  4 | 5 | 6
 *    |   |
 * ---+---+---
 *    |   |
 *  7 | 8 | 9
 *    |   |
 *
 * Each square can be empty, can be occupied by an X, or
 * can be occupied by an O.
 */

public class Ttt4 {

	// The number of empty spaces in the board.
	private static int spacesLeft;

	// If square [i][j] of the board is empty, board[i][j] = ' '.
	// If square [i][j] of the board contains an X, board[i][j] = 'X'.
	// If square [i][j] of the board contains an O, board[i][j] = 'O'.
	private static char[][] board;

	public static void main(String[] args) {
		// Welcome the users, create and draw an empty board,
		// then a coin toss for the first move.
		System.out.println("Welcome to Tic Tac Toe");
		System.out
				.println("Would you like to play Tic Tac Toe? Indicate 'yes' or 'no'");
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		tttPlay(answer);
	}

	public static void tttPlay(String yn) {
		Scanner scan = new Scanner(System.in);
		if (yn.toLowerCase().equals("yes")) {	
			initializeBoard();
			firstDraw();
			System.out
					.println("A coin toss will determine who moves first.\nPlease call (H)eads or (T)ails:");
			String call = scan.nextLine();
			char mark = 'X';
			char comp = 'O';

			// Until someone wins or the board is filled up, get
			// a legal move, make the move, and draw the board.
			// Player is always 'X' and computer is always 'O'
			if (coinToss(call)) {
				System.out
						.println("You won the coin toss, you have the first move.");
				while (true) {
					int square = getLegalMove(mark);
					move(square, mark);
					draw();
					if (is3InRow(mark)) {
						System.out.println(mark + " wins!");
						System.out
								.println("Would you like to play Tic Tac Toe again? Indicate 'yes' or 'no'");
						String answer = scan.nextLine();
						tttPlay(answer); // asks if want a new game and then
						break; // responds accordingly
					}

					if (isBoardFull() || isTieGame3() || isTieGame2(mark)
							|| isTieGame1(mark)) {
						System.out.println("Tie game!");
						System.out
								.println("Would you like to play Tic Tac Toe again? Indicate 'yes' or 'no'");
						String answer = scan.nextLine();
						tttPlay(answer); // asks if want a new game and then
						break; // responds accordingly
					}
					int compSquare = getLegalMoveComp(mark, comp);
					move(compSquare, comp);
					draw();
					if (is3InRow(comp)) {
						System.out.println(comp + " wins!");
						System.out
								.println("Would you like to play Tic Tac Toe again? Indicate 'yes' or 'no'");
						String answer = scan.nextLine();
						tttPlay(answer); // asks if want a new game and then
						break; // responds accordingly
					}

					if (isBoardFull() || isTieGame3() || isTieGame2(comp)
							|| isTieGame1(comp)) {
						System.out.println("Tie game!");
						System.out
								.println("Would you like to play Tic Tac Toe again? Indicate 'yes' or 'no'");
						String answer = scan.nextLine();
						tttPlay(answer); // asks if want a new game and then
						break; // responds accordingly
					}
				}
			} else {
				System.out
						.println("You lost the coin toss, the computer has the first move.");
				while (true) {
					int compSquare = getLegalMoveComp(mark, comp);
					move(compSquare, comp);
					draw();
					if (is3InRow(comp)) {
						System.out.println(comp + " wins!");
						System.out
								.println("Would you like to play Tic Tac Toe again? Indicate 'yes' or 'no'");
						String answer = scan.nextLine();
						tttPlay(answer); // asks if want a new game and then
						break; // responds accordingly
					}

					if (isBoardFull() || isTieGame3() || isTieGame2(comp)
							|| isTieGame1(comp)) {
						System.out.println("Tie game!");
						System.out
								.println("Would you like to play Tic Tac Toe again? Indicate 'yes' or 'no'");
						String answer = scan.nextLine();
						tttPlay(answer); // asks if want a new game and then
						break; // responds accordingly
					}
					int square = getLegalMove(mark);
					move(square, mark);
					draw();
					if (is3InRow(mark)) {
						System.out.println(mark + " wins!");
						System.out
								.println("Would you like to play Tic Tac Toe again? Indicate 'yes' or 'no'");
						String answer = scan.nextLine();
						tttPlay(answer); // asks if want a new game and then
						break; // responds accordingly
					}

					if (isBoardFull() || isTieGame3() || isTieGame2(mark)
							|| isTieGame1(mark)) {
						System.out.println("Tie game!");
						System.out
								.println("Would you like to play Tic Tac Toe again? Indicate 'yes' or 'no'");
						String answer = scan.nextLine();
						tttPlay(answer); // asks if want a new game and then
						break; // responds accordingly
					}
				}
			}

		} else if (yn.toLowerCase().equals("no")){
			System.out.println("Thank you for coming to Tic Tac Toe!");
		}
		else{
			System.out.println("We could not understand your response. \nPlease indicate 'yes' or 'no'");
			String answer = scan.nextLine();
			tttPlay(answer);
		}
	}

	// Pre: user selects head or tails
	// Post: A coin tossed and returns true if matches users prediction
	public static boolean coinToss(String call) {
		int called = -1;
		if (call.equals("H") || call.equals("h")) {
			called = 0;
		} else if (call.equals("T") || call.equals("t")) {
			called = 1;
		}
		else{
			System.out.println("We could not understand you response. Please indicate (H)eads or (T)ails:");
			Scanner scan = new Scanner(System.in);
			String resp = scan.nextLine();
			coinToss(resp);
		}
		java.util.Random rand = new java.util.Random();
		int toss = rand.nextInt(2);
		return (called == toss);
	}

	// Pre: mark is 'X' or 'O'
	// The current board contains an empty square
	// Post: Interacts with the user until the user provides the number
	// of an empty square in the board. It then returns that number.
	//
	public static int getLegalMove(char mark) {
		java.util.Scanner console = new java.util.Scanner(System.in);
		while (true) {
			System.out.println(mark + "'s next move: ");
			int square = console.nextInt();
			if ((square >= 1) && (square <= 9) && (isSquareEmpty(square))) {
				return square;
			}
			System.out.println("\nIllegal move, try again\n");
		}
	}

	// Pre: mark is 'X' or 'O'
	// The current board contains an empty square
	// Post: Checks if there are any moves the opponent can make to win the
	// game, and blocks them.
	// Then checks if there are any wins for computer to win and makes them.
	// Then tries to make two in a row along a row/column/diagonal that is
	// otherwise empty.
	// Then tries to play in a corner square of the center.
	// Then plays a random unfilled square.
	public static int getLegalMoveComp(char mark, char comp) {
		java.util.Random r = new java.util.Random();
		int square;
		// Block opponent's winning move
		square = imminentWin(mark);
		if ((square >= 1) && (square <= 9) && (isSquareEmpty(square))) {
			return square;
		}
		// Make own winning move
		square = imminentWin(comp);
		if ((square >= 1) && (square <= 9) && (isSquareEmpty(square))) {
			return square;
		}
		// Build two in a row
		square = twoInARow(comp);
		if ((square >= 1) && (square <= 9) && (isSquareEmpty(square))) {
			return square;
		}
		// Play a corner square or center
		square = playCornerCenter(comp);
		if ((square >= 1) && (square <= 9) && (isSquareEmpty(square))) {
			return square;
		}
		// Play a random square
		while (true) {
			square = (r.nextInt(9) + 1);
			if ((square >= 1) && (square <= 9) && (isSquareEmpty(square))) {
				return square;
			}
			System.out.println("\nIllegal move, try again\n");
		}
	}

	// Pre: mark is 'X' or 'O'
	// Post: plays a corner tile or center
	public static int playCornerCenter(char mark) {
		if (isSquareEmpty(1)) {
			return 1;
		} else if (isSquareEmpty(3)) {
			return 3;
		} else if (isSquareEmpty(5)) {
			return 5;
		} else if (isSquareEmpty(7)) {
			return 7;
		} else if (isSquareEmpty(9)) {
			return 9;
		}
		return 0;
	}

	// Pre: mark is 'X' or 'O'
	// Post: finds the first square with mark in it, and checks along the row,
	// column, and diagonal (as applicable) containing that square to see if
	// there
	// are two blank squares (ie checks that the marked square is the only
	// square filled
	// in that row/column/diagonal) and returns an adjacent square, to the one
	// with a
	// mark in it, along an otherwise empty row/column/diagonal
	public static int twoInARow(char mark) {
		// checks if the square 1 has mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column, diagonal
		if (board[0][0] == mark) {
			if (isSquareEmpty(2) && isSquareEmpty(3)) {
				return 2;
			} else if (isSquareEmpty(5) && isSquareEmpty(9)) {
				return 5;
			} else if (isSquareEmpty(4) && isSquareEmpty(7)) {
				return 4;
			}
		}
		// checks if square 2 has a mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column
		if (board[0][1] == mark) {
			if (isSquareEmpty(3) && isSquareEmpty(1)) {
				return 3;
			} else if (isSquareEmpty(5) && isSquareEmpty(8)) {
				return 5;
			}
		}
		// checks if square 3 has a mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column, diagonal
		if (board[0][2] == mark) {
			if (isSquareEmpty(2) && isSquareEmpty(1)) {
				return 2;
			} else if (isSquareEmpty(5) && isSquareEmpty(7)) {
				return 5;
			} else if (isSquareEmpty(6) && isSquareEmpty(9)) {
				return 6;
			}
		}
		// checks if square 4 has a mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column
		if (board[1][0] == mark) {
			if (isSquareEmpty(1) && isSquareEmpty(7)) {
				return 1;
			} else if (isSquareEmpty(5) && isSquareEmpty(9)) {
				return 5;
			}
		}
		// checks if square 5 has a mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column, diagonal
		if (board[1][1] == mark) {
			if (isSquareEmpty(1) && isSquareEmpty(9)) {
				return 1;
			} else if (isSquareEmpty(2) && isSquareEmpty(8)) {
				return 2;
			} else if (isSquareEmpty(3) && isSquareEmpty(7)) {
				return 3;
			} else if (isSquareEmpty(4) && isSquareEmpty(6)) {
				return 4;
			}
		}
		// checks if square 6 has a mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column
		if (board[1][2] == mark) {
			if (isSquareEmpty(3) && isSquareEmpty(9)) {
				return 3;
			} else if (isSquareEmpty(5) && isSquareEmpty(4)) {
				return 5;
			}
		}
		// checks if square 7 has a mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column, diagonal
		if (board[2][0] == mark) {
			if (isSquareEmpty(4) && isSquareEmpty(1)) {
				return 4;
			} else if (isSquareEmpty(5) && isSquareEmpty(3)) {
				return 5;
			} else if (isSquareEmpty(8) && isSquareEmpty(9)) {
				return 8;
			}
		}
		// checks if square 8 has a mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column
		if (board[2][1] == mark) {
			if (isSquareEmpty(7) && isSquareEmpty(9)) {
				return 7;
			} else if (isSquareEmpty(5) && isSquareEmpty(2)) {
				return 5;
			}
		}
		// checks if square 9 has a mark in it, and if so plays an adjacent
		// square in
		// an otherwise empty row, column, diagonal
		if (board[2][2] == mark) {
			if (isSquareEmpty(5) && isSquareEmpty(1)) {
				return 5;
			} else if (isSquareEmpty(6) && isSquareEmpty(3)) {
				return 6;
			} else if (isSquareEmpty(8) && isSquareEmpty(7)) {
				return 8;
			}
		}
		return 0;

	}

	// Pre: mark is 'X' or 'O'
	// Post: Will return the number of the first square checked that playing
	// would result in a win
	// for mark
	public static int imminentWin(char mark) {
		// check if there is an imminent win in first row
		if (board[0][0] == mark && board[0][1] == mark && isSquareEmpty(3)) {
			return 3;
		} else if (board[0][1] == mark && board[0][2] == mark
				&& isSquareEmpty(1)) {
			return 1;
		} else if (board[0][0] == mark && board[0][2] == mark
				&& isSquareEmpty(2)) {
			return 2;
		}
		// check if there is an imminent win in the second row
		else if (board[1][0] == mark && board[1][1] == mark && isSquareEmpty(6)) {
			return 6;
		} else if (board[1][1] == mark && board[1][2] == mark
				&& isSquareEmpty(4)) {
			return 4;
		} else if (board[1][0] == mark && board[1][2] == mark
				&& isSquareEmpty(5)) {
			return 5;
		}
		// check if there is an imminent win in the third row
		else if (board[2][0] == mark && board[2][1] == mark && isSquareEmpty(9)) {
			return 9;
		} else if (board[2][1] == mark && board[2][2] == mark
				&& isSquareEmpty(7)) {
			return 7;
		} else if (board[2][0] == mark && board[2][2] == mark
				&& isSquareEmpty(8)) {
			return 8;
		}
		// check if there is an imminent win in the first column
		else if (board[0][0] == mark && board[1][0] == mark && isSquareEmpty(7)) {
			return 7;
		} else if (board[0][0] == mark && board[2][0] == mark
				&& isSquareEmpty(4)) {
			return 4;
		} else if (board[2][0] == mark && board[1][0] == mark
				&& isSquareEmpty(1)) {
			return 1;
		}
		// check if there is an imminent win in the second column
		else if (board[0][1] == mark && board[1][1] == mark && isSquareEmpty(8)) {
			return 8;
		} else if (board[0][1] == mark && board[2][1] == mark
				&& isSquareEmpty(5)) {
			return 5;
		} else if (board[2][1] == mark && board[1][1] == mark
				&& isSquareEmpty(2)) {
			return 2;
		}
		// check if there is an imminent win in the third column
		else if (board[0][2] == mark && board[1][2] == mark && isSquareEmpty(9)) {
			return 9;
		} else if (board[0][2] == mark && board[2][2] == mark
				&& isSquareEmpty(6)) {
			return 6;
		} else if (board[2][2] == mark && board[1][2] == mark
				&& isSquareEmpty(3)) {
			return 3;
		}
		// check if there is an imminent win along the diagonal 1
		else if (board[0][0] == mark && board[1][1] == mark && isSquareEmpty(9)) {
			return 9;
		} else if (board[0][0] == mark && board[2][2] == mark
				&& isSquareEmpty(5)) {
			return 5;
		} else if (board[2][2] == mark && board[1][1] == mark
				&& isSquareEmpty(1)) {
			return 1;
		}
		// check if there is an imminent win along diagonal 2
		else if (board[0][2] == mark && board[1][1] == mark && isSquareEmpty(7)) {
			return 7;
		} else if (board[0][2] == mark && board[2][0] == mark
				&& isSquareEmpty(5)) {
			return 5;
		} else if (board[2][0] == mark && board[1][1] == mark
				&& isSquareEmpty(3)) {
			return 3;
		} else {
			return 0;
		}
	}

	// Initializes the board to be empty.
	public static void initializeBoard() {
		spacesLeft = 9;
		board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	// Post: Draws the board to standard output (screen) with the
	// square numbers
	public static void firstDraw() {
		System.out.println();
		System.out.println("   |   |   ");
		System.out.println(" " + 1 + " | " + 2 + " | " + 3);
		System.out.println("   |   |   ");
		System.out.println("---+---+---");
		System.out.println("   |   |   ");
		System.out.println(" " + 4 + " | " + 5 + " | " + 6);
		System.out.println("   |   |   ");
		System.out.println("---+---+---");
		System.out.println("   |   |   ");
		System.out.println(" " + 7 + " | " + 8 + " | " + 9);
		System.out.println("   |   |   ");
		System.out.println();
	}

	// Post: Draws the board to the standard output
	public static void draw() {
		System.out.println();
		System.out.println("   |   |   ");
		System.out.println(" " + board[0][0] + " | " + board[0][1] + " | "
				+ board[0][2]);
		System.out.println("   |   |   ");
		System.out.println("---+---+---");
		System.out.println("   |   |   ");
		System.out.println(" " + board[1][0] + " | " + board[1][1] + " | "
				+ board[1][2]);
		System.out.println("   |   |   ");
		System.out.println("---+---+---");
		System.out.println("   |   |   ");
		System.out.println(" " + board[2][0] + " | " + board[2][1] + " | "
				+ board[2][2]);
		System.out.println("   |   |   ");
		System.out.println();
	}

	// Pre: mark is 'X' or 'O'
	// 1 <= square <= 9
	// Post: Stores the specified mark in the specified
	// square of the board
	public static void move(int square, char mark) {
		if (isSquareEmpty(square)) {
			spacesLeft = spacesLeft - 1;
		}

		if (square == 1) {
			board[0][0] = mark;
		} else if (square == 2) {
			board[0][1] = mark;
		} else if (square == 3) {
			board[0][2] = mark;
		} else if (square == 4) {
			board[1][0] = mark;
		} else if (square == 5) {
			board[1][1] = mark;
		} else if (square == 6) {
			board[1][2] = mark;
		} else if (square == 7) {
			board[2][0] = mark;
		} else if (square == 8) {
			board[2][1] = mark;
		} else if (square == 9) {
			board[2][2] = mark;
		}
	}

	// Pre: 1 <= square <= 9
	// Post: Returns true if the specified square of the
	// board is empty; returns false otherwise.
	public static boolean isSquareEmpty(int square) {
		if (square == 1) {
			return board[0][0] == ' ';
		} else if (square == 2) {
			return board[0][1] == ' ';
		} else if (square == 3) {
			return board[0][2] == ' ';
		} else if (square == 4) {
			return board[1][0] == ' ';
		} else if (square == 5) {
			return board[1][1] == ' ';
		} else if (square == 6) {
			return board[1][2] == ' ';
		} else if (square == 7) {
			return board[2][0] == ' ';
		} else if (square == 8) {
			return board[2][1] == ' ';
		} else if (square == 9) {
			return board[2][2] == ' ';
		} else {
			return false;
		}
	}

	// Pre: mark is 'X' or 'O'
	// Post: Returns true if the board contains three of
	// the specified mark in a row; returns false
	// otherwise.
	public static boolean is3InRow(char mark) {
		return (board[0][0] == mark && board[1][0] == mark && board[2][0] == mark)
				|| (board[0][1] == mark && board[1][1] == mark && board[2][1] == mark)
				|| (board[0][2] == mark && board[1][2] == mark && board[2][2] == mark)
				|| (board[0][0] == mark && board[0][1] == mark && board[0][2] == mark)
				|| (board[1][0] == mark && board[1][1] == mark && board[1][2] == mark)
				|| (board[2][0] == mark && board[2][1] == mark && board[2][2] == mark)
				|| (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark)
				|| (board[2][0] == mark && board[1][1] == mark && board[0][2] == mark);
	}

	// Post: Returns true if the board contains no empty
	// spaces; returns false otherwise.
	public static boolean isBoardFull() {
		return spacesLeft == 0;
	}

	// Post: returns true if the board has three empty spaces
	// and can only result in a tie
	public static boolean isTieGame3() {
		return (spacesLeft == 3 && board[1][0] == ' ' && board[1][1] == ' '
				&& board[1][2] == ' ' && board[0][0] == 'X'
				&& board[0][2] == 'X' && board[2][1] == 'X')
				|| (spacesLeft == 3 && board[1][0] == ' ' && board[1][1] == ' '
						&& board[1][2] == ' ' && board[2][0] == 'X'
						&& board[0][1] == 'X' && board[2][2] == 'X')
				|| (spacesLeft == 3 && board[0][1] == ' ' && board[1][1] == ' '
						&& board[2][1] == ' ' && board[0][0] == 'X'
						&& board[2][0] == 'X' && board[1][2] == 'X')
				|| (spacesLeft == 3 && board[0][1] == ' ' && board[1][1] == ' '
						&& board[2][1] == ' ' && board[0][2] == 'X'
						&& board[1][0] == 'X' && board[2][2] == 'X');

	}

	// Pre: mark is 'X' or 'O'
	// Post: returns true if the board has two empty spaces
	// and can only result in a tie
	public static boolean isTieGame2(char mark) {
		return (spacesLeft == 2 && board[1][0] == ' ' && board[1][1] == ' ' // done
				&& board[0][0] == 'X' && board[0][2] == 'X' && board[2][1] == 'X')
				|| (spacesLeft == 2 && board[1][0] == ' ' && board[1][1] == ' ' // done
						&& board[2][0] == 'X' && board[0][1] == 'X' && board[2][2] == 'X')
				|| (spacesLeft == 2 && board[1][1] == ' ' && board[1][2] == ' ' // done
						&& board[0][0] == 'X' && board[0][2] == 'X' && board[2][1] == 'X')
				|| (spacesLeft == 2 && board[1][1] == ' ' && board[1][2] == ' ' // done
						&& board[2][0] == 'X' && board[0][1] == 'X' && board[2][2] == 'X')
				|| (spacesLeft == 2 && board[0][1] == ' ' && board[1][1] == ' ' // done
						&& board[0][0] == 'X' && board[2][0] == 'X' && board[1][2] == 'X')
				|| (spacesLeft == 2 && board[0][1] == ' ' && board[1][1] == ' ' // done
						&& board[0][2] == 'X' && board[1][0] == 'X' && board[2][2] == 'X')
				|| (spacesLeft == 2 && board[1][1] == ' ' && board[2][1] == ' ' // done
						&& board[0][0] == 'X' && board[2][0] == 'X' && board[1][2] == 'X')
				|| (spacesLeft == 2 && board[1][1] == ' ' && board[2][1] == ' '
						&& board[0][2] == 'X' && board[1][0] == 'X' && board[2][2] == 'X');
	}

	// Pre: mark is 'X' or 'O'
	// Post: returns true if the board has one empty space
	// and can only result in a tie by filling the empty space
	// with a test mark of the player whose turn it will be next.
	// If there is not a 3 in a row with the test mark, returns true.
	// If there is a 3 in a row, it removes the test mark so the final
	// turn may be played
	public static boolean isTieGame1(char mark) {
		int row = 0;
		int column = 0;
		if (spacesLeft == 1) {
			if (mark == 'X') {
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						if (board[i][j] == ' ') {
							board[i][j] = 'O';
							row = i;
							column = j;
						}
					}
				}
			} else if (mark == 'O') {
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						if (board[i][j] == ' ') {
							board[i][j] = 'X';
							row = i;
							column = j;
						}
					}
				}
			}
			if (is3InRow(mark)) {
				board[row][column] = ' ';
				return false;
			}
			return true;
		}
		return false;
	}

}