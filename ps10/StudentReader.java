import java.io.*;

public class StudentReader {

    private BufferedReader input;
    private String line;
    

    // Constructor
    public StudentReader(String fileName) throws IOException {
        input = new BufferedReader(new FileReader(fileName));
        line = readALine();
    }
    

    public String readALine () {
        String ln = "";
        try {
            ln = input.readLine();
        }
        catch (IOException e) {
            ;
        }
        return ln;
    }


    public int getSize() {
	String tempLine = line;
        if (line != null) {
            line = readALine(); // name of next student if exists
        }
	return Integer.parseInt(tempLine);
    }


    public boolean hasNext() {
        return line != null;
    }


    public Student readStudent() {
        Student s = new Student();
        s.setName(line.substring(6)); // line was read in in the constructor
                                      // in the previous call.
                                      // skip "Name: "
        line = readALine();  // Address
        s.setAddr(line.substring(9));  // skip "Address: "
        line = readALine();   
        s.setCity(line);
        line = readALine();
        s.setState(line);
        line = readALine();
        s.setZip(Integer.parseInt(line));
        line = readALine();   //Phone
        s.setPhone(line.substring(7)); //skip "Phone: "
        line = readALine();  //Id
        s.setId(Integer.parseInt(line.substring(4))); //skip "Id: " and convert to integer
        line = readALine();   //Major
        s.setMajor(line.substring(7)); //skip "Major: "
        line = readALine();   //GPA
        s.setGpa(Double.parseDouble(line.substring(5))); //skip "GPA: "

        line = readALine(); // read off a blank line

        // Read the name of next student if exists in the input file
        if (line != null) {
            line = readALine();
        }
        return s;
    }

}
