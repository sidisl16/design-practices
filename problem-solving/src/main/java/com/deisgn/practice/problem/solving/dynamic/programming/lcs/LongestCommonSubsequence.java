package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

public class LongestCommonSubsequence {

	public static int getLongestCommonSubsequenceRecursive(String x, String y, int m, int n) {

		// Lowest valid value
		if (m == 0 || n == 0) {
			return 0;
		}

		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return 1 + getLongestCommonSubsequenceRecursive(x, y, m - 1, n - 1);
		}

		return Math.max(getLongestCommonSubsequenceRecursive(x, y, m, n - 1),
				getLongestCommonSubsequenceRecursive(x, y, m - 1, n));
	}

	// Memoization
	// Bottom up approach
	static int[][] mem = new int[5][6];

	public static int getLongestCommonSubsequenceRecursiveMemoization(String x, String y, int m, int n) {

		// Lowest valid value
		if (m == 0 || n == 0) {
			return 0;
		}

		if (mem[m - 1][n - 1] > 0) {
			return mem[m - 1][n - 1];
		}

		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return (mem[m - 1][n - 1] = 1 + getLongestCommonSubsequenceRecursive(x, y, m - 1, n - 1));
		}

		return (mem[m - 1][n - 1] = Math.max(getLongestCommonSubsequenceRecursive(x, y, m, n - 1),
				getLongestCommonSubsequenceRecursive(x, y, m - 1, n)));
	}

	public static int getLongestCommonSubsequenceTopDownApproach(String x, String y, int m, int n) {
		int[][] mem = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {

				if (i == 0 || j == 0) {
					continue;
				}

				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					mem[i][j] = 1 + mem[i - 1][j - 1];
				} else {
					mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
				}
			}
		}

		printLcs(mem, m, n, x, y);

		return mem[m][n];
	}

	private static void printLcs(int[][] mem2, int m, int n, String x, String y) {
		int i = m;
		int j = n;
		String result = "";

		while (i > 0 && j > 0) {

			if (x.charAt(i-1) == y.charAt(j-1)) {
				i--;
				j--;
				result = x.charAt(i) + result;
				continue;
			}

			if (mem[i - 1][j] > mem[i][j - 1]) {
				i--;
			} else {
				j--;
			}

		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		String x = "abcd";
		String y = "abcbd";

		System.out.println(getLongestCommonSubsequenceTopDownApproach(x, y, x.length(), y.length()));
	}

}
