package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

public class LongestPallimdromicSubstring {

	public static void solution(String str) {

		int[][] dp = new int[str.length()][str.length()];

		int max = Integer.MIN_VALUE;

		for (int j = 0; j < str.length(); j++) {
			for (int i = 0; i <= j; i++) {
				if (i == j) {
					dp[i][i] = 1;
				} else if ((j - i + 1) == 2 && str.charAt(i) == str.charAt(j)) {
					dp[i][j] = 1;
					max = Math.max(max, j - i + 1);
				} else if ((j - i + 1) > 2 && (str.charAt(i) == str.charAt(j)) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					max = Math.max(max, j - i + 1);
				}
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		solution("aabaaca");
	}

}
