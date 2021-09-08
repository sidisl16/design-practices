package com.deisgn.practice.problem.solving.dynamic.programming;

import java.util.Arrays;

public class LongestPathInMatrix {

	private static int[][] memoization;

	public static int solution(int[][] matrix, int m, int n) {

		if (m >= matrix.length || n >= matrix.length || m < 0 || n < 0) {
			return 0;
		}
		
		if(memoization[m][n] > 0) {
			return memoization[m][n];
		}

		int p = Integer.MIN_VALUE, q = Integer.MIN_VALUE, r = Integer.MIN_VALUE, s = Integer.MIN_VALUE;

		if (n + 1 < matrix.length && matrix[m][n] + 1 == matrix[m][n + 1]) {
			p = 1 + solution(matrix, m, n + 1);
		}

		if (n - 1 >= 0 && matrix[m][n] + 1 == matrix[m][n - 1]) {
			q = 1 + solution(matrix, m, n - 1);
		}

		if (m + 1 < matrix.length && matrix[m][n] + 1 == matrix[m + 1][n]) {
			r = 1 + solution(matrix, m + 1, n);
		}

		if (m - 1 >= 0 && matrix[m][n] + 1 == matrix[m - 1][n]) {
			s = 1 + solution(matrix, m - 1, n);
		}

		return memoization[m][n] = max(p, q, r, s, 1);
	}

	private static int max(int... elements) {
		Arrays.sort(elements);
		return elements[elements.length - 1];
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };
		memoization = new int[matrix.length][matrix.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				max = Math.max(max, solution(matrix, i, j));
			}
		}
		System.out.println(max);
	}

}
