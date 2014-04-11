public class Car implements Comparable<Car> {
	private String make;
	private String model;
	private int year;
	private String color;
	private String owner;
	private int numRepairs;

	// blank car constructor
	public Car() {
		make = "";
		model = "";
		year = 2012;
		color = "";
		owner = "";
		numRepairs = 0;
	}

	// a car constructor (previous repairs)
	public Car(String nmake, String nmodel, int nyear, String ncolor,
			String nowner, int nnumRepairs) {
		make = nmake;
		model = nmodel;
		year = nyear;
		color = ncolor;
		owner = nowner;
		numRepairs = nnumRepairs;
	}
	
	// getters
	public int getYear(){
		return year;
	}
	
	public String getColor(){
		return color;
	}

	// sells car to the new owner (the name is the parameter)
	public void sellTo(String nowner) {
		owner = nowner;
	}

	// incements numRepairs by one to indicate car has received a repair
	public void repair() {
		numRepairs++;
	}

	// is a reliable car if it has not been repaired more than once per year on average so far.
	// This is assuming that the current year is 2012.
	public boolean isReliable() {
		return (((double) numRepairs / (2012 - (double) year)) <= 1);
	}

	// Comparable will compare the age of the cars
	public int compareTo(Car c) {
		if (year < c.year) {
			return -1;
		} else if (year == c.year) {
			return 0;
		} else {
			return 1;
		}
	}

	public String toString() {
		return "make: " + make + "\nmmodel: " + model + "\nyear: " + year
				+ "\ncolor: " + color + "\nowner: " + owner
				+ "\nnumber of repairs: " + numRepairs + "\nis a reiable car: " + isReliable();
	}

	public static void main(String[] args) {
		Car test = new Car("Nissan", "Xterra", 2008, "Black", "Jay", 3);
		System.out.println(test);
		test.sellTo("Kelsey");
		test.repair();
		test.repair();
		test.repair();
		test.repair();
		System.out.println("\n" + test);
	}
}
