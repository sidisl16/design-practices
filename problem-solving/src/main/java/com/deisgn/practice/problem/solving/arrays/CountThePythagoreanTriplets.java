package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;

public class CountThePythagoreanTriplets {

	public static void solution(int a[]) {

		int count = 0;

		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * a[i];
		}

		Arrays.sort(a);

		for (int i = a.length - 1; i >= 2; i--) {

			int l = 0;
			int r = i - 1;

			while (l < r) {

				int sum = a[l] + a[r];

				if (sum == a[i]) {
					count++;
				}

				if (sum > a[i]) {
					r--;
				} else {
					l++;
				}
			}

		}

		if (count > 0) {
			System.out.println("Yes Count -> "+count);
		} else {
			System.out.println("No");
		}

	}

	public static void main(String[] args) {
		int a[] = { 3, 2, 4, 6, 5 };
		solution(a);// Yes

		int a1[] = { 3, 2, 7 };
		solution(a1);// -1
	}
}
