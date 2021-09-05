package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

public class EditDistance {

	private static int[][] memoization;

	public static int getMinDistanceMemoization(String s1, String s2, int m, int n) {

		if (m == 0) {
			return n;
		}

		if (n == 0) {
			return m;
		}

		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return getMinDistanceMemoization(s1, s2, m - 1, n - 1);
		}

		if (memoization[m - 1][n - 1] > 0) {
			return memoization[m - 1][n - 1];
		}

		return memoization[m - 1][n - 1] = 1 + min(getMinDistanceMemoization(s1, s2, m, n - 1),
				getMinDistanceMemoization(s1, s2, m - 1, n), getMinDistanceMemoization(s1, s2, m - 1, n - 1));
	}

	public static int getMinDistanceTabulation(String s1, String s2, int m, int n) {

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
				}

			}
		}
		return dp[m - 1][n - 1];
	}

	private static int min(int i, int j, int k) {
		return Math.min(Math.min(i, j), k);
	}

	public static void main(String[] args) {
		String s1 = "sunday";
		String s2 = "saturday";
		memoization = new int[s1.length()][s2.length()];
		int editDist = getMinDistanceMemoization(s1, s2, s1.length(), s2.length());
		System.out.println(editDist);
		editDist = getMinDistanceTabulation(s1, s2, s1.length(), s2.length());
		System.out.println(editDist);
	}

}
