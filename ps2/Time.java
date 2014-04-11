//A program which takes two times (in hours, mins, secs), adds them and
//then displays the result in the same format
public class Time {

	public static void main(String[] args) {
		// Declare and assign variables for the two provided times
		int hour1 = 4;
		int min1 = 45;
		int sec1 = 23;
		int hour2 = 3;
		int min2 = 54;
		int sec2 = 58;
		//Declare and assign two variables which represent the two times entirely in seconds
		int time1 = (hour1 * 360) + (min1 * 60) + sec1;
		int time2 = (hour2 * 360) + (min2 * 60) + sec2;
		//Declare and assign a variable which is the sum of the two times in seconds
		int timeTotal = time1 + time2;
		//Declare and assign variable which convert the total time into hours, mins, and secs
		int hourTotal = timeTotal/360;
		int minTotal = (timeTotal%360)/60;
		int secTotal = (timeTotal%360)%60;
		//Display the two initial times and their sum in hours, mins, secs
		System.out.println("Time One is " + hour1 + " hours, " + min1 + " minutes, and " + sec1 + " seconds.");
		System.out.println("Time Two is " + hour2 + " hours, " + min2 + " minutes, and " + sec2 + " seconds.");
		System.out.println("The sum of Time One and Time Two is " + hourTotal + " hours, " + minTotal + 
				" minutes, and " + secTotal + " seconds.");
	}
}
