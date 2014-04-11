public class Pig {
    /* Purpose: Converts a sentence (a string containing words separated
     *          by white spaces) into Pig Latin.
     * Ex: pigifySentence("This is a sentence.")
     *          = isThay isway away entence.say
     *     pigifySentence("Here is\nanother \t one")
     *          = ereHay isway anotherway oneway
     */
    public static String pigifySentence (String sent) {
    	String pigged = "";
    	String[] pigArray = sent.split("[ \n\t]");
    	for (int i = 0; i < pigArray.length; i++){
    			pigArray[i] = pigifyWord(pigArray[i]);
    	}
    	for (int j = 0; j < pigArray.length; j++){
    		if (pigArray[j]==""){
    		}
    		else {
    		pigged = pigged.concat(pigArray[j] + " ");
    		}
    	}
    	return pigged;
    }
    /* Purpose: Converts a word into Pig Latin.
     * Ex: pigifyWord("apple") = "appleway"
     *     pigifyWord("strong") = "ongstray"
     */
    public static String pigifyWord (String word) {
    	int startPig = firstVowel(word);
    	if (startPig==0){
    		return word = word.concat("way");
    	}
    	else if (startPig<0){
    		return word;
    	}
    	else{
    		String move = word.substring(0,(startPig));
    		String stay = word.substring(startPig);
    		String pigged = stay.concat(move);
    		return word = pigged.concat("ay");
    	}
    }
    /* Purpose: Returns the index of the first vowel in word,
     *          or -1 if there is no vowel.
     * Ex: firstVowel("apple") = 0
     *     firstVowel("computer") = 1
     *     firstVowel("ftp") = -1
     */
    public static int firstVowel (String word) {
        String wordTest = word.toLowerCase();
    	int vowelAt = -1;
    	for (int i = 0; i < wordTest.length(); i++){
    		if (wordTest.charAt(i)=='a' || wordTest.charAt(i)=='e' || wordTest.charAt(i)=='i'
    				|| wordTest.charAt(i)=='o' || wordTest.charAt(i)=='u'){
    			vowelAt = i;
    			break;
    		}
    	}
    	return vowelAt;
    }   
    public static void main (String[] args) {
	System.out.println(firstVowel("this"));
	System.out.println(firstVowel("ftp"));
	
	System.out.println();

	System.out.println(pigifyWord("apple"));
	System.out.println(pigifyWord("strong"));
	System.out.println();

	System.out.println("Here is \n another \t example sentence with a newline character and a tab character in it");
	System.out.println();

	System.out.println(pigifySentence("It is sunny out today."));
	System.out.println(pigifySentence("This is a sentence."));
	System.out.println(pigifySentence("Here is\nanother \t one"));
    }
}
