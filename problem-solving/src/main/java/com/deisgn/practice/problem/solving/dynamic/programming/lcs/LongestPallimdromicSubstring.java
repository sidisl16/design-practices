package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

public class LongestPallimdromicSubstring {

	public static void solution(String str) {

		int[][] dp = new int[str.length()][str.length()];

		System.out.println();

		for (int i = 0; i < str.length(); i++) {
			dp[i][i] = 1;
		}

		for (int j = 1; j < str.length(); j++) {
			for (int i = 0; i < j; i++) {
				if ((j - i + 1) == 2 && str.charAt(i) == str.charAt(j)) {
					dp[i][j] = 1;
				} else if ((j - i + 1) > 2 && (str.charAt(i) == str.charAt(j)) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				System.out.print(dp[i][j] + " ");
				if(dp[i][j] == 1) {
					max = Math.max(max, j - i + 1);
				}
			}
			System.out.println();
		}
		System.out.println(max);

	}

	public static void main(String[] args) {
		solution("aabaaca");
	}

}
