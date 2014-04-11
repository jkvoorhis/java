//A program to calculate the real number average of five integers,
//and display this information.
public class Ave {

	public static void main(String[] args) {
		//Declare and assign five integer variables that will be used in the average
		int n1 = 5;
		int n2 = 27;
		int n3 = 12;
		int n4 = 16;
		int n5 = 62;
		//Declare and assign a real number variable that will compute the average of 
		//the five integer numbers 
		double average = (n1 + n2 + n3 + n4 + n5)/5.0;
		//Instruct program to display a line of text which tells the result of 
		//averaging the five chosen integers 
		System.out.println("The average of " + n1 + ", " + n2 + ", " + n3 + ", " + n4 + 
				", and " + n5 + " is " + average + ".");	
	}
}
