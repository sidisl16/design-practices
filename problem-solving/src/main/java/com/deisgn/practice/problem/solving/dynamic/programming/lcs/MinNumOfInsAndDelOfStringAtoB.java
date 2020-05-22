package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

/**
 * 
 * Minimum number of deletions and insertions to transform one string into
 * another Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The
 * task is to remove/delete and insert minimum number of characters from/in str1
 * so as to transform it into str2. It could be possible that the same character
 * needs to be removed/deleted from one point of str1 and inserted to some
 * another point.
 *
 */
public class MinNumOfInsAndDelOfStringAtoB {

	public static void print(String x, String y, int m, int n) {

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

		System.out.println("Insertion: " + (n - mem[m][n]) + " deletion: " + (m - mem[m][n]));
	}

	public static void main(String[] args) {
		String x = "heap";
		String y = "pea";

		print(x, y, x.length(), y.length());
	}

}
