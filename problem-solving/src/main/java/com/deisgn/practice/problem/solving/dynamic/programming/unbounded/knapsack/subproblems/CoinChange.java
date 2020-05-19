package com.deisgn.practice.problem.solving.dynamic.programming.unbounded.knapsack.subproblems;

public class CoinChange {

	public static int getMaxWays(int[] coin, int n, int sum) {

		int[][] mem = new int[n + 1][sum + 1];

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {

				if (j == 0) {
					mem[i][j] = 1;
					continue;
				}

				if (i == 0) {
					mem[i][j] = 0;
					continue;
				}

				if (coin[i - 1] <= j) {

					mem[i][j] = mem[i][j - coin[i - 1]] + mem[i - 1][j];

				} else {

					mem[i][j] = mem[i - 1][j];
				}

			}
		}
		return mem[n][sum];
	}

	public static void main(String[] args) {

		int[] coin = { 1, 2, 3 };
		int sum = 5;

		System.out.println(getMaxWays(coin, coin.length, sum));
	}

}
