package com.deisgn.practice.problem.solving.arrays;

public class EquilibriumPoint {

	public static void solution(int a[]) {

		int i = 0;
		int sum = 0;

		if (a.length == 1) {
			System.out.println(1);
			return;
		}

		while (i < a.length) {
			sum += a[i++];
		}

		int leftSum = 0;
		for (int j = 0; j < a.length; j++) {

			sum = sum - a[j];

			if (sum == leftSum) {
				System.out.println(j + 1);
				return;
			}

			leftSum = leftSum + a[j];
		}

		System.out.println(-1);
	}

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 2, 2 };
		solution(a);
	}

}
