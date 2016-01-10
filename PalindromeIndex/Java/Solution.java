
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
	    System.out.println(getIndexToMakePalindrome(scanner.nextLine()));
	}
    }

    public static int getIndexToMakePalindrome(final String str) {
	Integer firstPossibility = null;
	Integer secondPossibility = null;
	for(int i = 0, j = str.length() - 1 ; j > i ; i++, j--) {
	    if(str.charAt(i) != str.charAt(j)) {
		firstPossibility = i;
		secondPossibility = j;
		break;
	    }
	}
	if(firstPossibility == null && secondPossibility == null) return -1;
	
	for(int i = 0, j = str.length() - 1 ; j > i ; i++, j--) {
	    if(i == firstPossibility.intValue()) {
		i++;
		if(i >= j) break;
	    }
	    if(str.charAt(i) != str.charAt(j)) {
		return secondPossibility;
	    }
	}
	return firstPossibility;
    }
}
