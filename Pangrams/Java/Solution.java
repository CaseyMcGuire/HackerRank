import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
	final Scanner scanner = new Scanner(System.in);
	while(scanner.hasNextLine()) {
	    final boolean strIsPangram = isPangram(scanner.nextLine());
	    if(strIsPangram) {
		System.out.println("pangram");
	    } 
	    else {
		System.out.println("not pangram");
	    }
	}
    }

    /**
     * Returns whether the passed string is a pangram. A pangram is defined as a sentence
     * every letter in the alphabet.
     * 
     * @param str The string to check whether it is a pangram
     * @return True if the passed string is a pangram; false otherwise
     */
    public static boolean isPangram(final String str) {
	final Set<Character> letters = new HashSet<>();
	for(final char curChar : str.toCharArray()) {
	    if(!Character.isAlphabetic(curChar)) {
		continue;
	    }
	    letters.add(Character.toLowerCase(curChar));

	    if(letters.size() == 26) {
		return true;
	    }
	}
	return false;
    }
}

