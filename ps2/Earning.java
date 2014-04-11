//A program to compute the earnings based on provided fixed values
//and will display the results
public class Earning {
	
	public static void main(String[]args){
		//Declaring integer variables to indicate the number of hours worked a week and the hourly rate earned,
		//and assigning appropriate values
		int hours = 9;
		int rate = 8;
		//Declaring and assigning an integer variable to compute the amount of money earned based on the provided 
		//hours worked and hourly rate 
		int earned = hours * rate;
		//Instructing the program to display a line that will convey the hours worked, the hourly rate, and the 
		//total amount earned
		System.out.println("After working " + hours + " hours a week, at an hourly rate of $" + rate + ", I have earned $" + earned + ".");
	}
}
