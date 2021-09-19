package com.deisgn.practice.problem.solving.dynamic.programming.unbounded.knapsack.subproblems;

public class CanSum {
	
	public static boolean solTabulation(int[] a, int targetSum) {
		boolean[] dp = new boolean[targetSum + 1];
		dp[0] = true;

		for (int i = 0; i <= targetSum; i++) {
			if (dp[i]) {
				for (int n : a) {
					if (i + n < dp.length)
						dp[i + n] = true;
				}
			}
		}

		return dp[targetSum];
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 3, 4 };
		int sum = 7;
		System.out.println(solTabulation(a, sum));
	}
}
