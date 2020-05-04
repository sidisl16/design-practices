package com.deisgn.practice.problem.solving.arrays;

public class SpiralMatrix {

	public static void solution(int a[][]) {

		int m = a[0].length - 1;
		int n = a.length - 1;

		int row = 0;
		int col = 0;

		while (row <= n && col <= m) {
			for (int i = col; i <= m; i++) {
				System.out.print(a[row][i] + " ");
			}

			row++;

			for (int i = row; i <= n; i++) {
				System.out.print(a[i][m] + " ");
			}

			for (int i = m - 1; i >= col; i--) {
				System.out.print(a[n][i] + " ");
			}

			for (int i = n - 1; i >= row; i--) {
				System.out.print(a[i][col] + " ");
			}

			col++;
			m--;
			n--;
		}
	}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		solution(a);// 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
	}
}
