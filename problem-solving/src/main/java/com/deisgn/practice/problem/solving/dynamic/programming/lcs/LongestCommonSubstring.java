package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

public class LongestCommonSubstring {

	public static int getLongestCommonSubStringTopDownApproach(String x, String y, int m, int n) {
		int[][] mem = new int[m + 1][n + 1];
		int max_length = 0;
		int start = 0;

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {

				if (i == 0 || j == 0) {
					continue;
				}

				if (x.charAt(i - 1) == y.charAt(j - 1)) {

					mem[i][j] = 1 + mem[i - 1][j - 1];

					if (mem[i][j] > max_length) {
						max_length = mem[i][j];
						start = i - max_length;
					}
				} else {
					mem[i][j] = 0;
				}
			}
		}

		System.out.println(x.substring(start, start + max_length));

		return max_length;
	}

	public static void main(String[] args) {
		String x = "xabcddd";
		String y = "zzabdddcc";

		System.out.println(getLongestCommonSubStringTopDownApproach(x, y, x.length(), y.length()));
	}
}
