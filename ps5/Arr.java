public class Arr {
	//A method to create an array of random numbers of a specified size and upper-limit
	public static int[] randomArray(int size, int limit){
		int[] array = new int[size];
		java.util.Random r = new java.util.Random();
		for (int i = 0; i < size; i++) {
			array[i] = r.nextInt(limit);
		}
		return array;
	}
	//A method to sum the elements of an array of integers
	public static int arrSum(int[] A){
		int sum = 0;
		for (int i = 0; i < A.length; i++){
			sum = sum + A[i];
		}
		return sum;
	}
	//A method to check if an array contains a specific integer
	public static boolean contains(int[] A, int n){
		boolean tf = false;
		for (int i = 0; i < A.length; i++){
			if (A[i]==n){
				tf = true;
			}
		}
		return tf;
	}
	//A method to identify the index of an array where a specified
	//number can be found, if at all, in the array
	public static int contains2(int[] A, int n){
		int found = -1;
		for (int i = 0; i < A.length; i++){
			if (A[i]==n){
				found = i;
				break;
			}
		}
		return found;
	}
	//A method to test if an integer is a multiple of the integer being checked for
	public static boolean multipleCheck(int tested, int checking){
		boolean tf = false;
		if ((tested%checking)==0 && tested!=0){
			tf = true;
		}
		return tf;
	}
	//A method to count the number of elements of an array that are multiples
	//of a specified integer
	public static int countMultiplesOf(int[] A, int n){
		int count = 0;
		for (int i = 0; i < A.length; i++){
			if (multipleCheck(A[i], n)){
				count++;
			}
		}
		return count;
	}
	//A method to store the number of occurrences of integers in an array, where the index indicates
	//the integer checked for, and the element the number of occurrences
	public static int[] buildHistogram(int[] A, int bigger){
		int[] frequency = new int[bigger];
		for (int i = 0; i < A.length; i++){   //goes through the elements of the array
			for (int j = 0; j < bigger; j++){ //goes through possible values of the element
				if (A[i]==j){                 //when the value of the element is determined
					frequency[j]++;           //add a count to the corresponding index of the return array
				}
			}
		}
		return frequency;
	}
	//Generates a line of stars to be used to print a histogram
	public static String starLine (int n){
		String star = "";
		for (int i = 0; i < n; i++){
			star = star + "*";
		}
		return star;
	}
	//Prints a histogram chart for a given array
	public static void printHistogram(int[] A){
		for (int i = 0; i < A.length; i++){
			System.out.println(i + ": " + A[i] + ": " + starLine(A[i]));
		}
	}
	//Prints the elements of an array within square brackets and seperated by a space
	public static void print (int[] A) {
		System.out.print("[ ");
		for (int i = 0; i < A.length; i++) {
		    System.out.print(A[i] + " ");
		}
		System.out.print("]\n");
	}
	//creates an array of random numbers from 0-14 that has 100 elements, displays the array to check results against, 
	//finds the average of the array, determines if it contains an 8, when the first 8 occurs, and how many multiples
	//of 8 occur in the array. It then creates and prints a histogram for the array
	public static void main(String[] args){
		int[] rArray = randomArray(100, 15);
		System.out.print("The array to be worked with is:");
		print(rArray);
		double average = (double)(arrSum(rArray))/(rArray.length);
		System.out.println("The average of the array is: " + average);
		System.out.println("It is " + contains(rArray, 8) + " that the array contains an 8");
		System.out.println("An 8 is first found at index " + contains2(rArray,8) + " of the array");
		System.out.println("Multiples of the integer 8 occur " + countMultiplesOf(rArray, 8) + " time(s) in the array");
		int[] histogram = buildHistogram(rArray, 15);
		System.out.println("The histogram for this array is:");
		printHistogram(histogram);
	}
}
