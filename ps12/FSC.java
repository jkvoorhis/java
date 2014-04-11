// a fast spell checker using TreeSet
import java.io.*;
import java.util.*;

public class FSC {

	private static TreeSet<String> dictionary = readWords();

	// Read in the dictionary
	private static TreeSet<String> readWords() {
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					".//words1.txt"));
			TreeSet<String> dict = new TreeSet<String>();
			String line;
			while ((line = input.readLine()) != null) {
				dict.add(line); // TreeSet has 'add'
			}
			return dict;
		} catch (IOException e) {
			System.out.println("File open failed...");
			return null;
		}
	}

	// convert strings to lower case letters for spell checking
	private static String toLowerCase(String word) {
		String lowerWord = "";
		for (int i = 0; i < word.length(); i++) {
			lowerWord = lowerWord + Character.toLowerCase(word.charAt(i));
		}
		return lowerWord;
	}

	private static void checkALine(String line, int lineNo) {
		// System.out.println(lineNo + ": " + line); // for debugging
		String[] words = line.split("[ ,.?;:]");
		for (String w : words) {
			if (!(w.equals(""))) {
				String word = w;
				w = toLowerCase(w);
				if (!(dictionary.contains(toLowerCase(w)))) {
					System.out.println(lineNo + ", " + word);
				}
			}
		}
	}

	private static String readALine(BufferedReader input) {
		String line = "";
		try {
			line = input.readLine();
		} catch (IOException e) {
			;
		}
		return line;
	}

	public static void main(String[] args) throws IOException {

		String file2spell = ".//words1bad.txt";
		BufferedReader doc = new BufferedReader(new FileReader(file2spell));

		long startCheckTime = System.currentTimeMillis();
		int i = 1; // line number
		String line = readALine(doc);
		while (line != null) {

			// checkALine(line, i); // if multi-word line
			// not all lowercase

			if (!(dictionary.contains(line))) { // assume one word per
				System.out.println(i + ", " + line); // line, all lowercase.
			}
			i = i + 1;
			line = readALine(doc);
		}
		System.out.println("\n\nSpell Checking Time: "
				+ (System.currentTimeMillis() - startCheckTime)
				+ " milliseconds");
	}
}