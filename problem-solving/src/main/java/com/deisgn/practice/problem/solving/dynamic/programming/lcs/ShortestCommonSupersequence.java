package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

/**
 * 
 * Given two strings str1 and str2, find the shortest string that has both str1
 * and str2 as subsequences.
 *
 */
public class ShortestCommonSupersequence {

	public static int getMaxLength(String x, String y, int m, int n) {

		int[][] mem = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {

				if (i == 0 || j == 0) {
					continue;
				}

				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					mem[i][j] = 1 + mem[i - 1][j - 1];
				} else {
					mem[i][j] = Math.max(mem[i][j - 1], mem[i - 1][j]);
				}
			}
		}

		printMem(mem);

		printLcs(mem, m, n, x, y);

		return m + n - mem[m][n];
	}

	private static void printMem(int[][] mem) {
		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {
				System.out.print(mem[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void printLcs(int[][] mem, int m, int n, String x, String y) {
		int i = m;
		int j = n;
		String res = "";

		while (i > 0 && j > 0) {

			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				res = String.valueOf(x.charAt(i - 1)) + res;
				i--;
				j--;
				continue;
			}

			if (mem[i - 1][j] >= mem[i][j - 1]) {
				res = String.valueOf(x.charAt(i - 1)) + res;
				i--;
			} else {
				res = String.valueOf(y.charAt(j - 1)) + res;
				j--;
			}
		}

		while (i > 0) {
			res = String.valueOf(x.charAt(i - 1)) + res;
			i--;
		}

		while (j > 0) {
			res = String.valueOf(y.charAt(j - 1)) + res;
			j--;
		}

		System.out.println(res);
	}

	public static void main(String[] args) {
		String x = "aggtab";
		String y = "gxtxayb";

		System.out.println(getMaxLength(x, y, x.length(), y.length()));
	}

}
