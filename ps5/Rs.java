import java.util.Scanner;

public class Rs {
	//A function to initialize the board (use in main)
	public static char[][] boardInit(int size){
		char[][] board = new char[size][size];
		return board;
	}
	//A function to fill a specified cell of the board with an 'X' (use in rCellFill)
	public static void cellFill(char[][] A, int column, int row){
		A[column][row] = 'X';
	}
	//A function to test if a cell is filled or not (use in rCellFill)
	public static boolean checkFilled(char[][] A, int column, int row){
		if (A[column][row]=='X'){
			return true;
		}
		else{
			return false;
		}
	}
	//A function to calculate the number of cells needed to be filled, given the desired percent of cells
	//to be filled and the size of the board (use in rCellFill)
		public static int toFill(int fillPercent, int size){
			return (int)(((double)fillPercent/ (100.0))*(size*size));
		}
	//A function to select random cells of a square array (of dimensions 'size'x'size') and fill them,
	//after checking if they are filled, until the desired percent of the board is filled (use in main)
	public static void rCellFill(char[][] A, int size, int fillPercent){
		int cellsFilled = 0;
		int goal = toFill(fillPercent, size);
		java.util.Random r = new java.util.Random();
		while (cellsFilled < goal){
			int column = r.nextInt(size);
			int row = r.nextInt(size);
			if (checkFilled(A, column, row)==false){
				cellFill(A, column, row);
				cellsFilled++;
			}
		}
	}
	//A function to print the elements of a table, separated by spaces (use in main)
	public static void printTable (char[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j] + "   ");
			}
			System.out.println();
		}
	}
	//Using input from the keyboard, initialize a board of the requested size and fill it to 
	//the requested percent
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the size of your board as an integer:");
		int size = scan.nextInt();
		System.out.print("Please enter the percent of your board to be filled as an integer:");
		int percent = scan.nextInt();
		char[][] board = boardInit(size);
		rCellFill(board, size, percent);
		printTable(board);
	}
}
