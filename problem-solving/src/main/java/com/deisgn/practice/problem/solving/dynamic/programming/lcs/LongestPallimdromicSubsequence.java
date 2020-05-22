package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

/**
 * 
 * Longest Palindromic Subsequence Given a sequence, find the length of the
 * longest palindromic subsequence in it.
 *
 */
public class LongestPallimdromicSubsequence {

	public static int getMaxLength(String x, int m) {

		StringBuilder builder = new StringBuilder(x);
		String y = builder.reverse().toString();

		int[][] mem = new int[m + 1][m + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < m + 1; j++) {

				if (i == 0 || j == 0) {
					mem[i][j] = 0;
					continue;
				}

				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					mem[i][j] = 1 + mem[i - 1][j - 1];
				} else {
					mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
				}
			}
		}

		return mem[m][m];
	}

	public static void main(String[] args) {
		String x = "agbcba";
		System.out.println(getMaxLength(x, x.length()));
	}

}
