package com.deisgn.practice.problem.solving.strings;

public class LongestPallimdromDynamicProgramming {

	public static void solution(String str) {
		int m = str.length();
		int a[][] = new int[m][m];
		int maxLength = 0;
		int start = 0;

		for (int i = 0; i < m; i++) {
			a[i][i] = 1;
			maxLength = 1;
			start = i;
		}

		for (int i = 0; i < m - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				a[i][i + 1] = 1;
				maxLength = 2;
				start = i;
			}
		}

		for (int k = 3; k <= m; k++) {
			for (int i = 0; i < m - k + 1; i++) {

				int j = i + k - 1;

				if (str.charAt(i) == str.charAt(j) && a[i + 1][j - 1] == 1) {
					a[i][j] = 1;
					maxLength = k;
					start = i;
				}

			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}

		System.out.println(
				"Longest Pallimdrome of length -> " + maxLength + " is -> " + str.substring(start, start + maxLength));

	}

	public static void main(String[] args) {
		String str = "geeksskeeg";

		solution(str);

		str = "abdbca";

		solution(str);

	}

}
