//A program to calculate the multadditionization of various given
//Parameters

public class MultAdd {
	//A method which will return a double that is the product of the first two parameters
	//and then the sum of that product with the final parameter
	public static double multAdd(double x, double y, double z){
		return ((x*y)+z);
	}
	//A method which uses multAdd to calculate the value of an exponential function
	//for a value 'x,' which will then print the result
	public static void yikes(double x){
		double n = multAdd(x, Math.exp(-x), Math.sqrt(1-Math.exp(-x)));
		System.out.println("The value of the exponential function for x = " + x + ", is : " + n);
	}
	//A method to invoke multAdd for various uses, and to invoke yikes
	public static void main(String[] args){
		//Test the multAdd function and print result
		double test = multAdd(1, 2, 3); 
		System.out.println("The computed value should be 5.0, and is actually: " + test);
		//Declare and assign variable Pi, to be used in trig functions
		double PI = 3.141592653589793; 
		//Use multAdd for the given trig functions and display the result
		double trig = multAdd((1.0/3.0), Math.sin(PI/4), Math.cos(PI/4));
		System.out.println("The sum of the given trig functions is: " + trig);
		//Use multAdd for the given log functions and display the result
		double log = multAdd(1.0, Math.log(10), Math.log(20));
		System.out.println("The sum of the given log functions is: " + log);
		//Invoke yikes for a hard-coded value
		yikes(5.0);
		
	}

}
