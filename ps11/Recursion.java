public class Recursion {

	// recursive method to return the value of a double, x, raised to the nth
	// power
	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		} else {
			return x * power(x, n - 1);
		}
	}

	// returns the GCD of two integers
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else if (a % b == 0) {
			return b;
		} else {
			return gcd(b, (a % b));
		}
	}

	// returns the value of the fibonacci function for the int provided
	public static int fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	// returns the value of the given function for the parameter n
	public static int f(int n) {
		if (n < 3) {
			return n;
		} else {
			return f(n - 1) + 2 * (f(n - 2)) + 3 * (f(n - 3));
		}
	}

	// takes a string and prints it backwards with one char per line
	public static void printBackward(String s) {
		System.out.println(s.charAt(s.length() - 1));
		if (s.length() > 1) {
			s = s.substring(0, s.length() - 1);
			printBackward(s);
		}
	}

	// takes a string and prints one char per line
	public static void printString(String s) {
		System.out.println(s.charAt(0));
		if (s.length() > 1) {
			s = s.substring(1);
			printString(s);
		}
	}

	// takes a string and returns a new string that has reversed the parameter
	// string
	public static String reverseString(String s) {
		String rev = "";
		if (s.length() == 1) {
			return rev + s.charAt(0);
		} else {
			return rev + s.charAt(s.length() - 1)
					+ reverseString(s.substring(0, s.length() - 1));
		}
	}

	public static void main(String[] args) {
		System.out.println("power(3, 0) = " + power(3, 0));
		System.out.println("power(2, 5) = " + power(2, 5));
		System.out.println("power(3, 4) = " + power(3, 4));
		System.out.println("gcd(36, 20) = " + gcd(36, 20));
		System.out.println("gcd(34, 0) = " + gcd(34, 0));
		System.out.println("gcd(3346, 468) = " + gcd(3346, 468));
		System.out.println("fib(0) = " + fib(0)); // returns 0
		System.out.println("fib(1) = " + fib(1));
		System.out.println("fib(2) = " + fib(2));
		System.out.println("fib(3) = " + fib(3)); // returns 2
		System.out.println("fib(4) = " + fib(4)); // returns 3
		System.out.println("fib(10) = " + fib(10)); // returns 55
		System.out.println("f(2) = " + f(2));
		System.out.println("f(3) = " + f(3));
		System.out.println("f(10) = " + f(10));
		printBackward("Java Fun!");
		printString("Java Fun!");
		String reversed = reverseString("Java Fun!");
		System.out.println(reversed);
	}
}
