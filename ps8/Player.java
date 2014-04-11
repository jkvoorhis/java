public class Player {

	// The possible fields for a Player object
	private int jersey;
	private String position;
	private String name;
	private String height;
	private int weight;
	private double fgsp;
	private String status;
	private String dob;

	// A constructor for a Player object given no parameters
	public Player() {
		jersey = 0;
		position = "";
		name = "";
		height = "";
		weight = 0;
		fgsp = 0.0;
		status = "";
		dob = "0/0/0000";

	}

	// A constructor for a Player object given parameters for each possible
	// field
	public Player(int ijersey, String iposition, String iname, String iheight,
			int iweight, double ifgsp, String istatus, String idob) {
		jersey = ijersey;
		position = iposition;
		name = iname;
		height = iheight;
		weight = iweight;
		fgsp = ifgsp;
		status = istatus;
		dob = idob;
	}

	// Getters for each field
	public int getJersey() {
		return jersey;
	}

	public String getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public String getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public double getFGSP() {
		return fgsp;
	}

	public String getStatus() {
		return status;
	}

	public String getDOB() {
		return dob;
	}

	// Setter for each field
	public void setJersey(int njersey) {
		jersey = njersey;
	}

	public void setPosition(String nposition) {
		position = nposition;
	}

	public void setName(String nname) {
		name = nname;
	}

	public void setHeight(String nheight) {
		height = nheight;
	}

	public void setWeight(int nweight) {
		weight = nweight;
	}

	public void setFGSP(double nfgsp) {
		fgsp = nfgsp;
	}

	public void setStatus(String nstatus) {
		status = nstatus;
	}

	public void setDOB(String ndob) {
		dob = ndob;
	}

	// A toString method for Player
	public String toString() {
		return "(" + jersey + ", " + position + ", " + name + ", " + height
				+ ", " + weight + ", " + fgsp + ", " + status + ", " + dob
				+ ")";
	}

	// A method to determine the age of a player considering the month and year
	// the player was born
	public int getAge() {
		String[] dobArray = dob.split("[/]");
		int currentMonth = 3;
		int currentYear = 2012;
		int monthBorn = Integer.parseInt(dobArray[0]);
		int yearBorn = Integer.parseInt(dobArray[2]);
		if (currentMonth < monthBorn) {
			return currentYear - yearBorn - 1;
		} else {
			return currentYear - yearBorn;
		}
	}
}
