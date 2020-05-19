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

	public static void main(String[] args) {

		int[] length = { 1, 2, 3, 4 };

		int[] price = { 5, 6, 8, 10 };

		int lengthOfRod = 4;

		System.out.println(getMaxPrice(length, price, length.length, lengthOfRod));

	}
}
