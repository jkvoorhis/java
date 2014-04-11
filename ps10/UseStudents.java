import java.io.*;

public class UseStudents {

	public static void main(String[] args) throws IOException {

		String inputFileName = ".//src//s7.txt";
		// String inputFileName = ".\\s0.txt"; // Try this if the other
		// doesn't work on yours

		// Establish a input stream so that we can read the file
		StudentReader sreader = new StudentReader(inputFileName);

		// Read the number of entries first
		int numStudents = 0;
		if (sreader.hasNext()) {
			numStudents = sreader.getSize();
		}

		// Now that we know the size, we can create an array with that size
		Student[] students = new Student[numStudents];

		// Read the rest of the input file
		int i = 0;
		while (sreader.hasNext()) {
			Student s = sreader.readStudent();
			students[i] = s;
			i++;
		}

		// Compute the average GPA of all the students and output it
		// to the standard output, i.e., the console.
		double totalGPA = 0;
		for (int j = 0; j < numStudents; j++) {
			totalGPA = totalGPA + students[j].getGpa();
		}
		System.out.println("The Average GPA of the students: " + totalGPA
				/ numStudents);

		// Find the student with the highest GPA who is from California
		// and print the name and the GPA of that student.
		double highGpa = 0.0;
		Student highest = null;
		for (int j = 0; j < numStudents; j++) {
			if (students[j].getState().equals("California")
					&& students[j].getGpa() > highGpa) {
				highGpa = students[j].getGpa();
				highest = students[j];
			}
		}
		if (highest == null) {
			System.out.println("There are no students from California");
		} else {
			System.out.println(highest.getName() + " has the highest GPA of students from California, with a: "
					+ highest.getGpa());
		}

		// Finds and prints the number of students from each state
		// in this format:
		//
		// State, No of Students
		// Arizona, 5
		// California, 20
		// Oregon, 6
		// Washington, 7

		// an array holding all the names of the states
		String[] stateNames = { "Alabama", "Alaska", "Arizona",
			"Arkansas", "California", "Colorado", "Connecticut", "Delaware",
			"Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
			"Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
			"Massachusetts", "Michigan", "Minnesota", "Mississippi",
			"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
			"New Jersey", "New Mexico", "New York", "North Carolina",
			"North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
			"Rhode Island", "South Carolina", "South Dakota", "Tennessee",
			"Texas", "Utah", "Vermont", "Virginia", "Washington",
			"West Virginia", "Wisconsin", "Wyoming" };
		// an array of state objects
		State[] states = new State[50];
		for (int j = 0; j < 50; j++){
			states[j] = new State(); //initializes the array
			states[j].setSName(stateNames[j]); // assigns each state object a state name
		}
		// runs through the student array and counts the number of students from each state
		for (int j = 0; j < students.length; j++){
			for (int k = 0; k < 50; k++){
				if((students[j].getState()).equals(states[k].getSName())){
					states[k].setCount(states[k].getCount()+1);
				}
			}
		}
		// prints the state name and the number of students from there
		System.out.println("\nState, No of Students");
		for (int j = 0; j < 50; j++){
			if (states[j].getCount() != 0){
				System.out.println(states[j].getSName() + ", " + states[j].getCount());
			}
		}

	}

}
