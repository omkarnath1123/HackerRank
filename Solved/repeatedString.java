package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class repeatedString {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();
		long n = scanner.nextLong();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedStringFunction(s, n);
		System.out.println(result);
		scanner.close();
	}

	public static long repeatedStringFunction(String s, long n) {
		long aInString = 0;
		long aCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				aInString++;
			}
		}
		long repeatedString = n / s.length();
		aCount = repeatedString * aInString;
		int remainderString = (int) (n % s.length());
		String subString = s.substring(0, remainderString);

		for (int i = 0; i < subString.length(); i++) {
			if (s.charAt(i) == 'a') {
				aCount++;
			}
		}

		return aCount;
	}

}
