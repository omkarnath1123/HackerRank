package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class sockMerchant {

	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int[] ar = new int[n];
		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//		9
//		10 20 20 10 10 30 50 10 20
//		System.out.println(n);
//		System.out.println(arItems.toString());

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = sockMerchantFunction(n, ar);
		System.out.println(result);
		scanner.close();
	}

	public static int sockMerchantFunction(int n, int[] arr) {
		int pairs = 0;
		HashSet<Integer> store = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int value = arr[i];
			if (store.contains(value)) {
				pairs++;
				store.remove(value);
			} else {
				store.add(value);
			}
		}
		return pairs;
	}
}
