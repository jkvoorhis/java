//A program the makes change for a user inputed dollar value (using the Scanner utility)
//and displays the bill and coin break down

//import the Scanner package from the Java library
import java.util.Scanner;

public class Change {

	public static void main(String[] args) {
		// Create a variable which will read and store input from the keyboard
		Scanner scan = new Scanner(System.in);
		//Display a line prompting the user to input a dollar value for which to determine
		//the bill and coin representation
		System.out.print("The Change Maker!\n\nEnter the Dollar value you wish to make change for: ");
		// Declare and assign a real number variable to store the value the user inputs
		double dollars;
		dollars = scan.nextDouble();
		//Convert the double value into an integer number by multiplying by 100 so that coins values can be
		//determined
		int dollarsI = (int)(dollars*100);
		//Declare and assign the integer values representing the bills and coins 
		int twentyD = dollarsI/2000;
		int tenD = ((dollarsI%2000)/1000);
		int fiveD = (((dollarsI%2000)%1000)/500);
		int oneD = (((dollarsI%2000)%1000)%500)/100;
		int quarter = ((((dollarsI%2000)%1000)%500)%100)/25;
		int dime = (((((dollarsI%2000)%1000)%500)%100)%25)/10;
		int nickel = ((((((dollarsI%2000)%1000)%500)%100)%25)%10)/5;
		int penny = (((((((dollarsI%2000)%1000)%500)%100)%25)%10)%5);
		//Display the results to the user
		System.out.println("\nYour change is:\n     " + twentyD + " twenty dollar bills\n     " + tenD + 
				" ten dollar bills\n     " + fiveD + " five dollar bills\n     " + oneD + 
				" one dollar bills\n     " + quarter + " quarters\n     " + dime + " dimes\n     " + 
				nickel + " nickels\n     " + penny + " pennies");
	}
}
