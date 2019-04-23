package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class countingValleys {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		String s = scanner.nextLine();

//		8
//		UDDDUDUU
//		System.out.println(n);
//		System.out.println(s);

		int result = countingValleysFunction(n, s);
		System.out.println(result);
		scanner.close();

	}

	public static int countingValleysFunction(int n, String s) {
		int downhillCount = 0;
		int uphillCount = 0;
		String stackString = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'U') {
				if (stackString.length() == 0) {
					stackString = s.charAt(i) + stackString;
				} else if (stackString.charAt(0) == 'D') {
					stackString = stackString.substring(1, stackString.length());
					// count down hill
					if (stackString.length() == 0) {
						downhillCount++;
					}
				} else if (stackString.charAt(0) == 'U') {
					stackString = s.charAt(i) + stackString;
				}
			} else if (s.charAt(i) == 'D') {
				if (stackString.length() == 0) {
					stackString = s.charAt(i) + stackString;
				} else if (stackString.charAt(0) == 'U') {
					stackString = stackString.substring(1, stackString.length());
					// count up hill
					if (stackString.length() == 0) {
						uphillCount++;
					}
				} else if (stackString.charAt(0) == 'D') {
					stackString = s.charAt(i) + stackString;
				}
			}
		}
		return downhillCount;
	}

}
