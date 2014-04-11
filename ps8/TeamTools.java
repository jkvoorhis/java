public class TeamTools {
	
	// A method to convert a String representing a height in "Feet-Inches"
	// to inches (an integer)
	public static int ftinToInches(String height){
		String[] heightArray = height.split("[-]");
    	int feet = Integer.parseInt(heightArray[0]);
    	int inches = Integer.parseInt(heightArray[1]);
    	inches = inches + (feet*12);
    	return inches;
	}
	
	// A method to convert inches (integer) to a height in "Feet-Inches" (String)
	public static String inchesToFtIn(int inches){
		int feet = inches/12;
		inches = inches%12;
		String height = "";
		String ft = Integer.toString(feet);
		String in = Integer.toString(inches);
		height = height.concat(ft);
		height = height.concat("-");
		height = height.concat(in);
		return height;
	}

}
