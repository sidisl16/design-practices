package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

public class MinNoToInsertToMakeItPallimdrom {
	public static int getmaxLength(String x, int m) {
		StringBuilder builder = new StringBuilder(x);
		String y = builder.reverse().toString();
		int n = y.length();

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

		return (m - mem[m][n]);
	}

	public static void main(String[] args) {
		String x = "aebcbda";
		System.out.println(getmaxLength(x, x.length()));

	}
}
