//A program which will convert tempurates from 
//Celsius to Fahrenheit and vice versa

//import the scanner package from the java library
import java.util.Scanner;

public class Ugly{
	//A method to convert Celsius to Fahrenheit which will take one double
	//parameter, and return a double
	public static double c2f(double n){
		return (((n*9)/5)+32);
	}
	//A method to convert Fahrenheit to Celsius which will take one double
	//parameter, and return a double
	public static double f2c(double n){
		return(((n-32)*5)/9);
	}
	//A method asking the user to input a tempurature which it then converts 
	//by invoking either c2f or f2c, and then displays the result
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Celcius temperature (real number): ");
		double cel = scan.nextDouble();
		double fahr = c2f(cel);  // Line 1
		System.out.println(cel + " Celcius = " + fahr + " Fahrenheit.");
		System.out.print("Enter a Celcius temperature (real number): ");
		cel = scan.nextDouble();
		fahr = c2f(cel);        // Line 2
		System.out.println(cel + " Celcius = " + fahr + " Fahrenheit.");
		System.out.print("Enter a Fahrenheit temperature (real number): ");
		fahr = scan.nextDouble();
		cel = f2c(fahr);      // Line 3
		System.out.println(fahr + " Fahrenheit = " + cel + " Celcius.");
		System.out.print("Enter a Fahrenheit temperature (real number): ");
		fahr = scan.nextDouble();
		cel = f2c(fahr);      // Line 4
        System.out.println(fahr + " Fahrenheit = " + cel + " Celcius.");
	}
}