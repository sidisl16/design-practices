package com.deisgn.practice.problem.solving.dynamic.programming;

public class DiceThrow {

	private static int[][] memoization;

	public static int solution(int m, int n, int sum) {

		if (sum == 0 && n == 0) {
			return 1;
		} else if (sum <= 0 && n >= 1) {
			return 0;
		} else if (n == 0) {
			return 0;
		}

		if (memoization[n][sum] > 0) {
			return memoization[n][sum];
		}

		int count = 0;

		for (int i = 1; i <= m; i++) {
			count += solution(m, n - 1, sum - i);
		}

		return memoization[n][sum] = count;
	}

	public static void main(String[] args) {
		int m = 6, n = 3, sum = 8;
		memoization = new int[n + 1][sum + 1];
		System.out.println(solution(m, n, sum));
	}

}
