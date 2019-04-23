package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class jumpingOnClouds {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] ar = new int[n];
		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//		6
//		0 0 0 1 0 0
//		System.out.println(n);
//		System.out.println(arItems.toString());

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = jumpingOnCloudsFunction(ar);
		System.out.println(result);
		scanner.close();
	}

	public static int jumpingOnCloudsFunction(int[] c) {
		int jumps = 0, pointer1 = 1, pointer2 = 2;

		for (int i = 0; i <= c.length - 2; i++) {
			if (c[i] == 1) {
				pointer1++;
				pointer2++;
			} else {
				// for 0 0 0 1 0 0 end line case
				if (pointer2 >= c.length) {
					if (c[pointer1] == 0) {
						jumps++;
						pointer1++;
						pointer2++;
					} else {
						pointer1++;
						pointer2++;
					}
					continue;
				}
				if (c[pointer2] == 1) {
					jumps++;
					pointer1++;
					pointer2++;
				} else {
					jumps++;
					i = i + 1;
					pointer1 = pointer1 + 2;
					pointer2 = pointer2 + 2;
				}
			}
		}

		return jumps;
	}
}
