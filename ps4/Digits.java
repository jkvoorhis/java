import java.util.Scanner;

//A program to count the number of even and odd digits, and the number of zeros in an integer
public class Digits {
	//Function to determine if an integer is even or not
	public static boolean isEven(int a){
		return (a%2==0);
	}
	//A function to count the number of even digits
	public static int numEvens (int n){
		int count = 0;
		while (n > 0){
			if (isEven(n%10)){
				count++;
				n = n/10;
			}
			else {
				n = n/10;
			}
		}
		return count;
	}
	//A function to count the number of odd digits
	public static int numOdds (int n){
		int count = 0;
		while (n > 0){
			if (!isEven(n%10)){
				count++;
				n = n/10;
			}
			else {
				n = n/10;
			}
		}
		return count;
	}
	//A function to count the number of zeroes
	public static int numZeros (int n){
		int count = 0;
		while (n > 0){
			if ((n%10)==0){
				count++;
				n = n/10;
			}
			else {
				n = n/10;
			}
		}
		return count;
	}
	//A function that counts the number of even digits, odd digits, and zeros in
	//an integer all in one
	public static int numDigits (int n, int which){
		int count = 0;
		if (which == 2){
			while (n > 0){
				if (isEven(n%10)){
					count++;
					n = n/10;
				}
				else {
					n = n/10;
				}
			}
		}
		if (which == 1){
			while (n > 0){
				if (!isEven(n%10)){
					count++;
					n = n/10;
				}
				else {
					n = n/10;
				}
			}
		}
		if (which == 0){
			while (n > 0){
				if ((n%10)==0){
					count++;
					n = n/10;
				}
				else {
					n = n/10;
				}
			}
		}
		return count;
	}
	//A method to read an Integer input from keyboard and display the number of even and odd digits,
	//and the number of zeros in the integer.
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		//Problem 2:
		System.out.print("Enter an Integer number:");
		int test = scan.nextInt();
		System.out.println(test + " contains " + numEvens(test) + " evens, " + numOdds(test)
				+ " odds, and " + numZeros(test) + " zeros.");
		//Problem 3:
		System.out.print("Enter an Integer number:");
		int test1 = scan.nextInt();
		System.out.println(test1 + " contains " + numDigits(test1, 2) + " evens, " + numDigits(test1, 1)
				+ " odds, and " + numDigits(test1, 0) + " zeros.");
	}
}
