package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01.subproblems;

public class MinimumSubsetDifference {

	public static int solution(int[] a, int n) {

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		boolean[][] mem = new boolean[n + 1][sum + 1];

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {

				if (j == 0) {
					mem[i][j] = Boolean.TRUE;
					continue;
				}

				if (i == 0) {
					mem[i][j] = Boolean.FALSE;
					continue;
				}

				if (a[i - 1] <= j) {

					mem[i][j] = mem[i - 1][j - a[i - 1]] || mem[i - 1][j];

				} else {

					mem[i][j] = mem[i - 1][j];

				}

			}
		}

		for (int j = 0; j < sum + 1; j++) {
			System.out.print(String.format("%6s", mem[n][j]));
		}

		System.out.println();

		for (int j = 0; j < sum + 1; j++) {

			if (mem[n][j]) {
				min = Math.min(Math.abs(2 * j - sum), min);
			}

			System.out.print(String.format("%6d", Math.abs(2 * j - sum)));
		}

		System.out.println();

		return min;
	}

	public static void main(String[] args) {
		int[] a = { 1, 6, 11, 5 };
		System.out.println(solution(a, a.length));// 1
	}

}
