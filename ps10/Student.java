public class Student {

	// Fields:
	private String name;
	private String addr;
	private String city;
	private String state;
	private int zip;
	private String phone;
	private int id;
	private String major;
	private double gpa;

	// Constructor:
	public Student() {
		name = "";
		addr = "";
		city = "";
		state = "";
		zip = 0;
		phone = "";
		id = 0;
		major = "";
		gpa = 0.0;
	}

	// Getters: 
	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}

	public int getId() {
		return id;
	}

	public String getMajor() {
		return major;
	}

	public double getGpa() {
		return gpa;
	}

	// Setters:
	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	// A toString method to print students if desired
	public String toString() {
		return "Name: " + name + "\nAddress: " + addr + "\n" + city + "\n"
				+ state + "\n" + zip + "\nPhone: " + phone + "\nId: " + id
				+ "\nMajor: " + major + "\nGPA: " + gpa;
	}

}
