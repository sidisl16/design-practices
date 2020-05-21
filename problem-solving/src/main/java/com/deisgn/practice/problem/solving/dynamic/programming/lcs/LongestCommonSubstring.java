package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

public class LongestCommonSubstring {

	public static int getLongestCommonSubStringTopDownApproach(String x, String y, int m, int n) {
		int[][] mem = new int[m + 1][n + 1];
		int max_length = 0;

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {

				if (i == 0 || j == 0) {
					continue;
				}

				if (x.charAt(i - 1) == y.charAt(j - 1)) {

					mem[i][j] = 1 + mem[i - 1][j - 1];
					max_length = Math.max(max_length, mem[i][j]);

				} else {
					mem[i][j] = 0;
				}
			}
		}

		return max_length;
	}

	public static void main(String[] args) {
		String x = "abcd";
		String y = "abcbd";

		System.out.println(getLongestCommonSubStringTopDownApproach(x, y, x.length(), y.length()));
	}
}
