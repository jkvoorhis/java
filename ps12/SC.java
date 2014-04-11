// a spell checker that checks user inputed words
import java.io.*;
import java.util.*;

public class SC {

	private static ArrayList<String> dictionary = readWords();

	// Read in the dictionary
	public static ArrayList<String> readWords() {
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					".//words1.txt"));
			ArrayList<String> dict = new ArrayList<String>();
			String line;
			while ((line = input.readLine()) != null) {
				dict.add(line);
			}
			return dict;
		} catch (IOException e) {
			System.out.println("File open failed...");
			return null;
		}
	}

	// converts words to lower case
	private static String toLowerCase(String word) {
		String lowerWord = "";

		for (int i = 0; i < word.length(); i++) {
			lowerWord = lowerWord + Character.toLowerCase(word.charAt(i));
		}
		return lowerWord;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("\nEnter a word to spell check: ");
			String word = scan.next();
			if (word.equals("q") || word.equals("Q")) { // end program if user "q"uits
				break;
			}
			String w = toLowerCase(word); // check the spelling of the inputed word
			if (dictionary.contains(w)) {
				System.out.println("   " + word + ": Yes");
			} else {
				System.out.println("   " + word + ": No!");
			}
		}
	}
}