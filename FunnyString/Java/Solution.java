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
	    final boolean isFunnyString = isFunnyString(scanner.nextLine());
	    if(isFunnyString) {
		System.out.println("Funny");
	    } else {
		System.out.println("Not Funny");
	    }
	}
    }

    /**
     * Returns whether the passed string is funny.
     *
     * @param str The str to check whether its funny.
     * @return True if the string is funny; false otherwise
     */
    public static boolean isFunnyString(final String str) {
	for(int i = 1, j = str.length() - 2 ; i < str.length() && j >= 0 ; i++, j--) {
	    final int forwardChar = absoluteValue((int) (str.charAt(i) - str.charAt(i - 1)));
	    final int backwardChar = absoluteValue((int) (str.charAt(j) - str.charAt(j + 1)));
	    if(forwardChar != backwardChar) return false;
	}
	return true;
    }
    
    /**
     * Returns the absolute value of the passed int.
     *
     * @param num The number we want the absolute value of.
     * @return The absolute value of num
     */
    public static int absoluteValue(final int num) {
	return num < 0 ? -num : num;
    }
}
