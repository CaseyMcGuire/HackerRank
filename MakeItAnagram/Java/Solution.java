import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
	final Scanner scanner = new Scanner(System.in);
	final String first = scanner.nextLine();
	final String second = scanner.nextLine();

	System.out.println(minNumDeletionsToMakeAnagram(first, second));
    }


    public static int minNumDeletionsToMakeAnagram(final String str1, final String str2) {
	final Map<Character, Integer> charToNumOccurrences1 = getMapFromCharToNumOccurrences(str1);
	final Map<Character, Integer> charToNumOccurrences2 = getMapFromCharToNumOccurrences(str2);
	
	int numDeletionsNeeded = 0;
	for(final Map.Entry<Character, Integer> entry : charToNumOccurrences1.entrySet()) {
	    final Character curChar = entry.getKey();
	    final Integer numOccurrencesIn1 = entry.getValue();
	    Integer numOccurrencesIn2 = charToNumOccurrences2.remove(curChar);

	    if(numOccurrencesIn2 == null) numOccurrencesIn2 = 0;

	    final Integer larger = Math.max(numOccurrencesIn1, numOccurrencesIn2);
	    final Integer smaller = Math.min(numOccurrencesIn1, numOccurrencesIn2);
	    
	    final Integer numDeletions = larger - smaller;
	    
	    numDeletionsNeeded += numDeletions;
	}
	
	
	for(final Integer i : charToNumOccurrences2.values()) {
	    numDeletionsNeeded += i;
	}
	
	return numDeletionsNeeded;
    }

    private static Map<Character, Integer> getMapFromCharToNumOccurrences(final String str) {
	final Map<Character, Integer> charToNumOccurrences = new HashMap<>();

	for(int i = 0 ; i < str.length() ; i++) {
	    final char curChar = str.charAt(i);
	    Integer numOccurrences = charToNumOccurrences.get(curChar);
	    if(numOccurrences == null) numOccurrences = 0;
	    charToNumOccurrences.put(curChar, numOccurrences + 1);
	}

	return charToNumOccurrences;
    }
}
