
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static final int IMPOSSIBLE_TO_BE_ANAGRAM = -1;
    
    public static void main(String[] args) {
	final Scanner scanner = new Scanner(System.in);
	final int numInputs = Integer.parseInt(scanner.nextLine());

	for(int i = 0 ; i < numInputs ; i++) {
	    final String curInput = scanner.nextLine();
	    final int stringLength = curInput.length();
	    
	    //if string is odd, the two substrings can't possibly be anagrams of each other
	    if(stringLength % 2 != 0) {
		System.out.println(IMPOSSIBLE_TO_BE_ANAGRAM);
	    } else {
		final String first = curInput.substring(0, stringLength / 2);
		final String second = curInput.substring(stringLength / 2, stringLength);

		System.out.println(minDeletionsToBeAnagram(first, second));
	    }
	}
    }

    public static int minDeletionsToBeAnagram(final String str1, final String str2) {
	final Map<Character, Integer> numCharOccurrences1 = getNumCharOccurrences(str1);
	final Map<Character, Integer> numCharOccurrences2 = getNumCharOccurrences(str2);
	
	int numChangesNeeded = 0;
	for(Map.Entry<Character, Integer> entry : numCharOccurrences1.entrySet()) {
	    final Character curChar = entry.getKey();
	    final Integer curCharNumOccurrences = entry.getValue();
	    Integer secondStringOccurrences = numCharOccurrences2.get(curChar);
	    if(secondStringOccurrences == null) secondStringOccurrences = 0;
	    
	    final int numDifferences = curCharNumOccurrences - secondStringOccurrences;
	    if(numDifferences > 0) numChangesNeeded += numDifferences;
	}
	return numChangesNeeded;
    }

    public static Map<Character, Integer> getNumCharOccurrences(final String str) {
	final Map<Character, Integer> numCharOccurrences = new HashMap<>();
	for(int i = 0 ; i < str.length() ; i++) {
	    Integer curNumOccurrences = numCharOccurrences.get(str.charAt(i));
	    if(curNumOccurrences == null) curNumOccurrences = 0;
	    numCharOccurrences.put(str.charAt(i), curNumOccurrences + 1);
	}
	return numCharOccurrences;
    }

}
