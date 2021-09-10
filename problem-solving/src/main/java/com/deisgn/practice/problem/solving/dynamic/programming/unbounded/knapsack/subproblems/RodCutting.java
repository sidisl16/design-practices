package com.deisgn.practice.problem.solving.dynamic.programming.unbounded.knapsack.subproblems;

public class RodCutting {

	public static int getMaxPrice(int[] length, int[] price, int n, int sum) {

		// in most problems sum and n are same

		int[][] mem = new int[n + 1][sum + 1];

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {

				if (i == 0 || j == 0) {
					mem[i][j] = 0;
					continue;
				}

				if (length[i - 1] <= j) {

					mem[i][j] = Math.max(price[i - 1] + mem[i][j - length[i - 1]], mem[i - 1][j]);

				} else {

					mem[i][j] = mem[i - 1][j];
				}

			}
		}

		return mem[n][sum];
	}

	private static int[][] memoization;

	public static int getMaxPriceRecursive(int[] length, int[] price, int n, int rodlength) {

		if (rodlength == 0 || n == 0) {
			return 0;
		}

		if (memoization[n - 1][rodlength] > 0) {
			return memoization[n - 1][rodlength];
		}

		if (length[n - 1] <= rodlength) {

			return memoization[n - 1][rodlength] = Math.max(
					price[n - 1] + getMaxPrice(length, price, n, rodlength - length[n - 1]),
					getMaxPrice(length, price, n - 1, rodlength));
		}

		return memoization[n - 1][rodlength] = getMaxPrice(length, price, n - 1, rodlength);
	}

	public static void main(String[] args) {

		int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };

		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };

		int lengthOfRod = 8;

		System.out.println(getMaxPrice(length, price, length.length, lengthOfRod));

		memoization = new int[length.length + 1][length.length + 1];
		System.out.println(getMaxPriceRecursive(length, price, length.length, lengthOfRod));

	}
}
