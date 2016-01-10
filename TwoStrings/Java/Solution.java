
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
	final Scanner scanner = new Scanner(System.in);
	final int numTestCases = Integer.parseInt(scanner.nextLine());
	for(int i = 0 ; i < numTestCases ; i++) {
	    final String first = scanner.nextLine();
	    final String second = scanner.nextLine();
	    if(containsCommonSubstring(first, second)) {
		System.out.println("YES");
	    } else {
		System.out.println("NO");
	    }
	}
    }

    /**
     * Returns whether the two passed strings have any common substrings.
     *
     * @param str1 The first string to check
     * @param str2 The second string to check
     * @return True if they have a common substring; false otherwise
     */
    public static boolean containsCommonSubstring(final String str1, final String str2) {
	
	//Since single characters are substrings, we just have to check if the two
	//strings have at least one common character
	final Set<Character> uniqueCharacters = new HashSet<>();
	
	for(int i = 0 ; i < str1.length() ; i++) {
	    uniqueCharacters.add(str1.charAt(i));
	}
	
	for(int i = 0 ; i < str2.length() ; i++) {
	    if(uniqueCharacters.contains(str2.charAt(i))) return true;
	}

	return false;
    }
}
