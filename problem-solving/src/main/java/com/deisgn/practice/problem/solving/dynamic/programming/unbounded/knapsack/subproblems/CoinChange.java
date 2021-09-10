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

	private static int[][] memoization;

	public static int getMaxWaysRecursive(int[] coin, int n, int sum) {
		
		if (sum == 0) {
			return 1;
		}

		if ((sum < 0 && n >= 1) || n==0) {
			return 0;
		}
		
		if(memoization[n-1][sum] > 0) {
			return memoization[n-1][sum];
		}
		
		return memoization[n - 1][sum] = getMaxWaysRecursive(coin, n, sum - coin[n - 1]) + getMaxWaysRecursive(coin, n - 1, sum);
	}

	public static void main(String[] args) {

		int[] coin = { 1, 2, 3 };
		int sum = 5;

		System.out.println(getMaxWays(coin, coin.length, sum));

		memoization = new int[coin.length + 1][sum + 1];
		System.out.println(getMaxWaysRecursive(coin, coin.length, sum));
	}

}
