public class Iphone {

	private String name; // name of the iPhone
	private int price; //price of the iPhone
	private double display; // diagonal display length (inches)
	private int memory; // memory in giga bytes
	private boolean compass; //true if it has a compass
	private String color; //color of the iPhone
	private boolean siri; // true if it has Siri
	private int serial; // the assigned serial number of the iPhone
	private static int serialGen; //used to generate serial numbers
	private static Iphone[] phoneSet = new Iphone[20]; // an array of iPhones
	private static int phones = 0; // used to assign a position in the array
	private int messages; // tracks number of messages on the phone

	// A constructor for an Iphone object without any parameters. Sets
	// appropriate default values. Also adds the phone to the array of phones
	// and changes the next serial number.
	public Iphone() {
		name = "";
		this.serial = serialGen;
		price = 0;
		display = 0.0;
		memory = 0;
		compass = false;
		color = "";
		siri = false;
		serialGen++;
		phoneSet[phones] = this;
		phones++;
		messages = 0;
	}

	// A constructor for iPhone, without the additional attributes of color and
	// siri, given starting parameters. Also adds the phone to the array of
	// phones and changes the next serial number.
	public Iphone(String name, int price, double display, int memory,
			boolean compass) {
		this.name = name;
		this.serial = serialGen;
		this.price = price;
		this.display = display;
		this.memory = memory;
		this.compass = compass;
		serialGen++;
		phoneSet[phones] = this;
		phones++;
		messages = 0;
	}

	// A constructor for iPhone, with the additional attributes of color and
	// siri, given starting parameters. Also adds the phone to the array of
	// phones and changes the next serial number.
	public Iphone(String name, int price, double display, int memory,
			boolean compass, String color, boolean siri) {
		this.name = name;
		this.serial = serialGen;
		this.price = price;
		this.display = display;
		this.memory = memory;
		this.compass = compass;
		this.color = color;
		this.siri = siri;
		serialGen++;
		phoneSet[phones] = this;
		phones++;
		messages = 0;
	}

	// A method to remove an Iphone from the array of phones, move the other
	// Iphones so there are no gaps in the array and adjusts the phones variable
	// accordingly
	public static void remove(Iphone a) {
		for (int i = 0; i < phones; i++) {
			if (phoneSet[i].equals(a)) {
				phoneSet[i] = phoneSet[phones - 1];
				phones--;
			}
		}
	}

	// A method to leave a message on a phone
	public void leaveMessage() {
		messages++;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getSerial() {
		return serial;
	}

	public int getPrice() {
		return price;
	}

	public double getDisplay() {
		return display;
	}

	public int getMemory() {
		return memory;
	}

	public boolean getCompass() {
		return compass;
	}

	public String getColor() {
		return color;
	}

	public boolean getSiri() {
		return siri;
	}

	// method to return the number of messages on a specific phone
	public int getMessages() {
		return messages;
	}

	// method to return the number of messages on all of the phones
	public static int getTotalNumberOfMessages() {
		int totalMessages = 0;
		for (int i = 0; i < phones; i++) {
			totalMessages = totalMessages + phoneSet[i].getMessages();
		}
		return totalMessages;
	}

	// Setters (note: no setter for serial number as that should never change
	// once assigned)
	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setDisplay(double display) {
		this.display = display;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public void setCompass(boolean compass) {
		this.compass = compass;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setSiri(boolean siri) {
		this.siri = siri;
	}

	// Designates how Iphone objects should be printed
	public String toString() {
		return "(" + name + ", " + serial + ", " + price + ", " + display
				+ ", " + memory + ", " + messages + ", " + compass + ", " + color + ", " + siri + ")";
	}
	// Prints each Iphone object on a separate line
	public static void print(String intro){
		System.out.println(intro);
		for (int i = 0; i < phones; i++){
			System.out.println("    " + phoneSet[i]);
		}
	}

}
