public class PassengerCar extends Car {

	private int numPassengers;
	private int numDoors;
	private String transmissionType;

	//constructor
	public PassengerCar(String nmake, String nmodel, int nyear, String ncolor,
			String nowner,int nnumRepairs, int numPassengers, int numDoors, 
			String transmissionType) {
		super(nmake, nmodel, nyear, ncolor, nowner, nnumRepairs);
		this.numPassengers = numPassengers;
		this.numDoors = numDoors;
		this.transmissionType = transmissionType;
	}

	// car is comfortable if it can seat at least Şve people and if it has at
	// least four doors and it is not older than Şve years
	public boolean isComfortable() {
		return (numPassengers > 4 && numDoors > 3 && (2012-getYear()) < 6);
	}

	// car is hard to drive if it is a manual
	public boolean isHardToDrive() {
		return (transmissionType.equals("manual"));
	}

	public String toString() {
		return super.toString() + "\nnumber of passengers: " + numPassengers
				+ "\nnumber of doors: " + numDoors + "\ntransmission type: "
				+ transmissionType + "\nis comfortable: " + isComfortable()
				+ "\nis hard to drive: " + isHardToDrive();
	}

	public static void main(String[] args) {
		PassengerCar test1 = new PassengerCar("Nissan", "Xterra", 2008,
				"Black", "Jay", 3, 5, 4, "manual");
		System.out.println(test1);
		PassengerCar test2 = new PassengerCar("Nissan", "Altima", 2004,
				"Blue", "Kelsey", 12, 4, 4, "automatic");
		System.out.println("\n" + test2);
		int compare = test1.compareTo(test2);
		if (compare == 0){
			System.out.println("the Xterra is equal in age to the Altima");
		}
		else if (compare == -1){
			System.out.println("the Xterra is older than the Altima");
		}
		else {
			System.out.println("the Xterra is newer than the Altima");
		}
	}
}
