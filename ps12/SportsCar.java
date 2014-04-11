public class SportsCar extends Car {
	int maxSpeed;
	double seconds;
	boolean isConvertable;

	// constructor
	public SportsCar(String nmake, String nmodel, int nyear, String ncolor,
			String nowner, int nnumRepairs, int nmaxSpeed, double nseconds,
			boolean nisConvertable) {
		super(nmake, nmodel, nyear, ncolor, nowner, nnumRepairs);
		maxSpeed = nmaxSpeed;
		seconds = nseconds;
		isConvertable = nisConvertable;
	}

	// returns true is car is snazzy (ie f it can drive faster than 150 miles per hour and it is convertible,
	// and its color is red, purple, or yellow)
	public boolean isSnazzy() {
		return (maxSpeed > 150 && isConvertable == true && 
				(getColor().equals("red")
				|| getColor().equals("purple") 
				|| getColor().equals("yellow")));
	}

	public String toString() {
		return super.toString() + "\nmax speed: " + maxSpeed
				+ "\nseconds for 0 to 60: " + seconds + "\nis a convertable: "
				+ isConvertable;
	}

	public static void main(String[] args) {
		SportsCar test1 = new SportsCar("BMW", "M5", 2008, "Black", "Jay", 13,
				200, 3.5, false);
		System.out.println(test1);
		SportsCar test2 = new SportsCar("Audi", "A3", 2011, "Red", "Kelsey", 3,
				220, 2.5, true);
		System.out.println("\n" + test2);
		int compare = test1.compareTo(test2);
		if (compare == 0) {
			System.out.println("the BMW is equal in age to the Audi");
		} else if (compare == -1) {
			System.out.println("the BMW is older than the Audi");
		} else {
			System.out.println("the BMW is newer than the Audi");
		}
	}

}
