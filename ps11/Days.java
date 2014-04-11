// A class to track the days of the week and assign them each a value
// The day of the week must be spelled correctly and have the first letter capitalized
public class Days {

	private String day; // will track what day of the week it being represented
	private int value; // will hold corresponding value to day of the week

	public Days() {
		day = "";
		value = -1;
	}

	public Days(String day) {
		this.day = day;
		if (day.equals("Monday")) {
			value = 0;
		}
		if (day.equals("Tuesday")) {
			value = 1;
		}
		if (day.equals("Wednesday")) {
			value = 2;
		}
		if (day.equals("Thursday")) {
			value = 3;
		}
		if (day.equals("Friday")) {
			value = 4;
		}
		if (day.equals("Saturday")) {
			value = 5;
		}
		if (day.equals("Sunday")) {
			value = 6;
		}
	}

	// getters
	public String getDay() {
		return day;
	}

	public int getValue() {
		return value;
	}

	// setters

	// updates the value associated with a Days object
	public void setValue(int value) {
		this.value = value;
		if (value == 7) {
			this.value = 0;
		}
	}

	// sets the Days object to a day of the week based on string input, which is
	// a day of the week, and assigns its corresponding value
	public void setDay(String day) {
		this.day = day;
		if (day.equals("Monday")) {
			value = 0;
		}
		if (day.equals("Tuesday")) {
			value = 1;
		}
		if (day.equals("Wednesday")) {
			value = 2;
		}
		if (day.equals("Thursday")) {
			value = 3;
		}
		if (day.equals("Friday")) {
			value = 4;
		}
		if (day.equals("Saturday")) {
			value = 5;
		}
		if (day.equals("Sunday")) {
			value = 6;
		}
	}

	// sets the Days object to a day of the week based on integer input, which
	// corresponds to a day of the week, and assigns its corresponding string
	// representation
	public void setDay(int value) {
		this.value = value;
		if (value == 0) {
			day = "Monday";
		}
		if (value == 1) {
			day = "Tuesday";
		}
		if (value == 2) {
			day = "Wednesday";
		}
		if (value == 3) {
			day = "Thursday";
		}
		if (value == 4) {
			day = "Friday";
		}
		if (value == 5) {
			day = "Saturday";
		}
		if (value == 6) {
			day = "Sunday";
		}
	}

}
