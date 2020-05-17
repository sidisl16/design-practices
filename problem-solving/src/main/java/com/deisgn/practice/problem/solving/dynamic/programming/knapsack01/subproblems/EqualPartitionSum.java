package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01.subproblems;

public class EqualPartitionSum {

	public static boolean solution(int[] a, int n) {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		return sum % 2 != 0 ? false : subsetSum(a, sum / 2, n);
	}

	private static boolean subsetSum(int[] a, int sum, int n) {

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

		return mem[n][sum];
	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 11, 5 };
		System.out.println(solution(a, a.length));
		int[] b = { 1, 5, 11, 5, 6 };
		System.out.println(solution(b, b.length));
	}

}
