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
	    System.out.println(getMinimumNumCharsToDelete(scanner.nextLine()));
	}
    }

    /**
     * Given a string made up only of A' and B's, returns the minimum number of deletions needed
     * to make the string alternative between A's and B's.
     *
     * @param str The string to check
     * @return The minimum number of deletions to make the string alternate between A's and B's
     */
    private static int getMinimumNumCharsToDelete(final String str) {
	if(str.equals("")) return 0;
	char lastChar = str.charAt(0);
	int numDeletions = 0;

	for(int i = 1 ; i < str.length() ; i++) {
	    if(lastChar == str.charAt(i)) {
		numDeletions++;
	    }
	    else {
		lastChar = str.charAt(i);
	    }
	}
	
	return numDeletions;
    }
}
