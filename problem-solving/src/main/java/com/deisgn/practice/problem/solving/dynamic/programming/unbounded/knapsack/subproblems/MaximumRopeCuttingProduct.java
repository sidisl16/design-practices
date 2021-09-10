package com.deisgn.practice.problem.solving.dynamic.programming.unbounded.knapsack.subproblems;

public class MaximumRopeCuttingProduct {

	private static int maxProduct = Integer.MIN_VALUE;

	public static void getMax(int n, int rodLength, int prod) {

		if (rodLength == 0) {
			maxProduct = Math.max(maxProduct, prod);
			return;
		}

		if (n <= 0) {
			return;
		}

		if (rodLength <= 0 && n - 1 >= 1) {
			return;
		}

		getMax(n, rodLength - n, prod * n);
		getMax(n - 1, rodLength, prod);
	}

	public static void main(String[] args) {
		int rodLength = 10;
		// Special case
		if (rodLength == 2) {
			System.out.println(1);
			return;
		}
		getMax(rodLength, rodLength, 1);
		System.out.println(maxProduct);
	}

}
