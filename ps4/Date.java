//A program to display the date in in m/d/yyyy format based on compile-time
//input of the month as a String, day and year as ints

public class Date {
	//A method to take the month as a word and return its corresponding month-number
	public static String month(String m){
		if (m=="January"){
			return "1";
		}
		if (m=="February"){
			return "2";
		}
		if (m=="March"){
			return "3";
		}
		if (m=="April"){
			return "4";
		}
		if (m=="May"){
			return "5";
		}
		if (m=="June"){
			return "6";
		}
		if (m=="July"){
			return "7";
		}
		if (m=="August"){
			return "8";
		}
		if (m=="September"){
			return "9";
		}
		if (m=="October"){
			return "10";
		}
		if (m=="November"){
			return "11";
		}
		if (m=="December"){
			return "12";
		}
		return m;
	}
	//The method which defines the function which will take the month, as a word, the day and 
	//the year and return a string in m/d/y format
	public static String alphaToNum(String m, int d, int y){
		return (month(m) + "/" + d + "/" + y);
	}
	//Testing the alphaToNum function
	public static void main(String[] args) {
		System.out.print("alphaToNum(\"February\", 7, 2012) should be 2/7/2012");
		System.out.println(" : " + alphaToNum("February", 7, 2012));
		System.out.print("alphaToNum(\"July\", 10, 1990) should be 7/10/1990");
		System.out.println(" : " + alphaToNum("July", 10, 1990));
		System.out.print("alphaToNum(\"May\", 2, 1960) should be 5/2/1960");
		System.out.println(" : " + alphaToNum("May", 2, 1960));
		System.out.print("alphaToNum(\"April\", 7, 1988) should be 4/7/1988");
		System.out.println(" : " + alphaToNum("April", 7, 1988));
		}
}
