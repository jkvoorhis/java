public class Rev {
	//A function to reverse the elements of an array of integers
	public static void reverse (int[] A){
		int i = 0;
		int j = A.length -1;
		while (i < j){
			int leftBefore = A[i];
			int rightBefore = A[j];
			A[j] = leftBefore;
			A[i] = rightBefore;
			i++;
			j--;
			}
		}
	//A function to print the elements of an array, separated by spaces, within square brackets
	public static void print (int[] A){
		System.out.print("[ ");
		for (int i = 0; i < A.length; i++) {
		    System.out.print(A[i] + " ");
		}
		System.out.print("]\n");
	}
	//Create arrays, print them, reverse them and print the reversed array
	public static void main (String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		print(arr);
		reverse(arr);
		print(arr);
		int[] arr1 = {5,2,4,6,4,2,2,4,5,7,4,2,4,6,7};
		print(arr1);
		reverse(arr1);
		print(arr1);
		int[] arr2 = {1,2,3,4};
		print(arr2);
		reverse(arr2);
		print(arr2);
	}
}
