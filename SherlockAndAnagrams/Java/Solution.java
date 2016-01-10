
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
	final Scanner scanner = new Scanner(System.in);
	final int numInputs = Integer.parseInt(scanner.nextLine());
	for(int i = 0 ; i < numInputs ; i++) {
	    System.out.println(getNumAnagramaticSubstrings(scanner.nextLine()));
	}
    }

    public static int getNumAnagramaticSubstrings(final String str) {
	int numAnagramaticSubstrings = 0;
	for(int i = 1 ; i < str.length() ; i++) {
	    numAnagramaticSubstrings += getNumAnagramaticSubstringsOfLength(str, i);
	}
	return numAnagramaticSubstrings;
    }

    private static int getNumAnagramaticSubstringsOfLength(final String str, final int length) {
	int numAnagramaticPairs = 0;
	final Map<Anagram, Integer> substringToNumOccurrences = new HashMap<>();

	for(int i = 0 ; i <= str.length() - length; i++) {

	    final Anagram curSubstring = new Anagram(str.substring(i, i + length));
	    Integer numOccurrences = substringToNumOccurrences.get(curSubstring);

	    if(numOccurrences == null) {
		numOccurrences = 0;
	    } else {
		numAnagramaticPairs += numOccurrences;
	    }

	    substringToNumOccurrences.put(curSubstring, numOccurrences + 1);
	}
	return numAnagramaticPairs;
    }
    
}

class Anagram {
    private final Map<Character, Integer> charsToOccurrences;
    
    public Anagram(final String str) {
	charsToOccurrences = new HashMap<>();
	for(int i = 0 ; i < str.length() ; i++) {
	    Integer curNumOccurrences = charsToOccurrences.get(str.charAt(i));
	    if(curNumOccurrences == null) curNumOccurrences = 0;
	    charsToOccurrences.put(str.charAt(i), curNumOccurrences + 1);
	}
    }

    public Map<Character, Integer> getCharsToOccurrences() {
	return charsToOccurrences;
    }
    
    @Override 
    public boolean equals(Object o) {
	if(o == null) return false;
	if(!(o instanceof Anagram)) return false;
	return ((Anagram)o).getCharsToOccurrences().equals(this.charsToOccurrences);
    }

    @Override
    public int hashCode() {
	return charsToOccurrences.hashCode();
    }
}
