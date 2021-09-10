package com.deisgn.practice.problem.solving.dynamic.programming.unbounded.knapsack.subproblems;

public class CoinChangeII {

	public static int getMinNoOfCoins(int[] coin, int n, int sum) {

		int[][] mem = new int[n + 1][sum + 1];
		int MAX = Integer.MAX_VALUE - 1;

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {

				if (i == 0) {
					mem[i][j] = MAX;
					continue;
				}

				if (j == 0) {
					mem[i][j] = 1;
					continue;
				}

				if (i == 1) {
					if (coin[i - 1] % j == 0) {
						mem[i][j] = coin[i - 1] / j;
					} else {
						mem[i][j] = MAX;
					}
					continue;
				}

				if (coin[i - 1] <= j) {

					mem[i][j] = Math.min(mem[i][j - coin[i - 1]] + 1, mem[i - 1][j]);

				} else {

					mem[i][j] = mem[i - 1][j];
				}

			}
		}

		print(mem, coin);
		return mem[n][sum];
	}

	private static void print(int[][] mem, int[] a) {

		for (int j = 0; j < mem[0].length; j++) {
			System.out.print((j == 0 ? "      " : "") + "|" + String.format("%6d", j) + "| | ");
		}

		System.out.println();

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {
				System.out.print((j == 0 ? String.format("%2d", (i == 0 ? 0 : a[i - 1])) : "") + " | "
						+ (j == 0 ? i : "") + "|" + String.format("%6s", mem[i][j]) + "|");
			}
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------");

		}

	}

	static int minCount = Integer.MAX_VALUE;

	public static int getMinCoinsRecursive(int[] coin, int n, int sum, int count) {

		if (sum == 0) {
			minCount = Math.min(minCount, count);
			return 1;
		}

		if ((sum < 0 && n >= 1) || n == 0) {
			return 0;
		}

		return getMinCoinsRecursive(coin, n, sum - coin[n - 1], count + 1)
				+ getMinCoinsRecursive(coin, n - 1, sum, count);
	}

	public static void main(String[] args) {

		int[] coin = { 25, 10, 5 };
		int sum = 30;

		System.out.println(getMinNoOfCoins(coin, coin.length, sum));

		getMinCoinsRecursive(coin, coin.length, sum, 0);

		System.out.println(minCount);
	}

}
