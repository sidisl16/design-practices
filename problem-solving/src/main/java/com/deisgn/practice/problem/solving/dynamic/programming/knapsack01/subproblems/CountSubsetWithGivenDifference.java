package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01.subproblems;

public class CountSubsetWithGivenDifference {

	public static int soluttion(int[] a, int n, int diff) {

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		int s1 = (sum + diff) / 2;

		int[][] mem = new int[n + 1][s1 + 1];

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

				if (a[i - 1] <= j) {

					mem[i][j] = mem[i - 1][j - a[i - 1]] + mem[i - 1][j];

				} else {

					mem[i][j] = mem[i - 1][j];

				}

			}
		}

		return mem[n][s1];
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 3 };
		System.out.println(soluttion(a, a.length, 1));// 3
	}

}
