import java.util.Scanner; 
import java.util.Random;

//A slot machine game
public class Slot {
	//A function to randomly generate a number between 1 and 9
	public static int rand(){
		Random randgen = new Random();
		int a = randgen.nextInt(9);
		return a+1;
	}
	//A function to determine if three integers contain a double
	public static boolean doubles(int a, int b, int c){
		if (a == b || a == c || b == c){
			return true;
		}
		else {
			return false;
		}
	}
	//A function to determine if three integers contain a triple
	public static boolean triples(int a, int b, int c){
		if (a == b && b==c){
			return true;
		}
		else {
			return false;
		}
	}
	//A function to calculate the percentage of two integers
	public static int percent(int a, int b){
		return (int) (((double) a / (double) b) * 100);
	}
	//Variables to track total times played and how many of each outcome
	//type result
	public static int count = 0;
	public static int tripleCount = 0;
	public static int doubleCount = 0;
	public static int singleCount = 0;
	//A function to play the slot pull game
	public static void slotPull(int a){
		if (a == 1){ //indicates they want to play
			count++; //when game is played it is added to total count
			int x = rand();
			int y = rand();
			int z = rand();
			System.out.println("The numbers you drew are: " + x + ", " + y + ", " + z + ", ");
			if (doubles(x, y, z)){ //checks for doubles and adds to count
				System.out.println("    wow, double luck!");
				doubleCount++;
			}
			if (triples(x, y, z)){ //checks for triples and adds to count
				System.out.println("    wow, triple luck!");
				tripleCount++;
			}
			if (!triples(x, y, z) && !doubles(x, y, z)) { //checks for singles and adds to count
				System.out.println("    Better luck next time!");
				singleCount++;
			}
			//ask if want to play again and then sends back to start of function
			System.out.print("Continue? (enter 1 to continue 2 to stop):");
			Scanner scan = new Scanner(System.in);
			a = scan.nextInt();
			slotPull(a);
		}
		else if (a == 2){ //indicates do not want to play, and so displays results of game
			System.out.println("Out of " + count + " hands, you had\n    " + tripleCount + " triple jackpots (" + 
			percent(tripleCount, count) + "%),\n    " + doubleCount + " doubles (" + 
			percent(doubleCount, count) + "%),\n    " + singleCount + " singles (" + 
			percent(singleCount, count) + "%) today!!!\nCome again...");
		}
		else { //if something other than a 1 or a 2 is inputed, lets player try again
			System.out.println("Please enter a 1 to continue or a 2 to stop:");
			Scanner scan = new Scanner(System.in);
			a = scan.nextInt();
			slotPull(a);
		}
	}
	//Starts the slot pull game
	public static void main (String[] args){
		System.out.print("Continue? (enter 1 to continue 2 to stop):");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		slotPull(x);
	}
}
