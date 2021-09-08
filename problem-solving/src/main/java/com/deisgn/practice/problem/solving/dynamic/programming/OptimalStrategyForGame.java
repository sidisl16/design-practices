package com.deisgn.practice.problem.solving.dynamic.programming;

public class OptimalStrategyForGame {

	public static int solution(int[] table) {

		int[][] dp = new int[table.length][table.length];

		for (int g = 0; g < table.length; g++) {
			for (int i = 0, j = g; j < table.length; i++, j++) {
				if (i == j) {
					dp[i][j] = table[i];
				} else if (j - i + 1 == 2) {
					dp[i][j] = Math.max(table[i], table[j]);
				} else {

					int mini = Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
					int minj = Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
					dp[i][j] = Math.max(table[i] + mini, table[j] + minj);
				}
			}
		}

		return dp[0][table.length - 1];
	}

	public static void main(String[] args) {
		int[] table = new int[] { 5, 3, 7, 10 };
		System.out.println(solution(table));
	}
}