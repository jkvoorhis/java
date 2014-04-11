//A program to display the Pascal triangle for a given size
public class Pascal {
	//A function to compute factorials
	public static int factorial (int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	//A function to compute the binomial coefficients of a given integer
	//and print them  
	public static void binomialCoef(int n){
		int j = 0;
		while (j<=n){
			System.out.print((factorial(n)/(factorial(n-j)*factorial(j))) + " ");
			j = j + 1;
		}
		System.out.print("\n");
	}
	//A function to produce the desired number of spaces before the binomial coefficients
	public static String spaces(int b){
		String space = " ";
		String c = "";
		int i = 0;
		while (i < b){
			c = c + space;
			i++;
		}
		return c;
	}
	//A function to create the Pascal triangle
	public static void drawPascal(int n){
		int i = 0;
		int b = n;
		while (i < n){
			System.out.print(spaces(b));
			binomialCoef(i);
			i++;
			b--;
		}
		binomialCoef(i);
		
	}
	//Display the Pascal triangle of size 3, and size 7
	public static void main (String[] args){
		drawPascal(3);
		System.out.println("\n");
		drawPascal(7);
	}
}
