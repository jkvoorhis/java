//A program to convert a user inputed dollar value into Euros and Japanese Yen
//using the Scanner utility package

//import the Scanner package from the Java library
import java.util.Scanner;

public class Exchange {

	public static void main(String[] args) {
		// Create a variable which will read and store input from the keyboard
		Scanner scan = new Scanner(System.in);
		//Display a line prompting the user to input a dollar value to be
		//converted into Euros and Japanese Yen
		System.out.print("A Dollar to Euro and Japanese Yen converter.\n\nEnter the Dollar value you wish to convert: ");
		// Declare and assign a real number variable to store the value the user inputs
		double dollars;
		dollars = scan.nextDouble();
		//Using the current exchange rate, declare and assign double variables which convert the
		//dollar value into Euros and the Japanese Yen
		double euros = dollars*0.758;
		double yen = dollars*76.7;
		//Display the results of the conversion for the user
		System.out.println("\n$" + dollars + " becomes: " + euros + " Euros, or " + yen + " Japanese Yen.");	
	}
}
