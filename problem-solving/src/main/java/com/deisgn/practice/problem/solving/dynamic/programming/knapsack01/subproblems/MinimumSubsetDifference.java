package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01.subproblems;

public class MinimumSubsetDifference {

	public static int solution(int[] a, int n) {

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		boolean[][] mem = new boolean[n + 1][sum + 1];

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {

				if (j == 0) {
					mem[i][j] = Boolean.TRUE;
					continue;
				}

				if (i == 0) {
					mem[i][j] = Boolean.FALSE;
					continue;
				}

				if (a[i - 1] <= j) {

					mem[i][j] = mem[i - 1][j - a[i - 1]] || mem[i - 1][j];

				} else {

					mem[i][j] = mem[i - 1][j];

				}

			}
		}

		for (int j = 0; j < sum + 1; j++) {
			System.out.print(String.format("%6s", mem[n][j]));
		}

		System.out.println();

		for (int j = 0; j < sum + 1; j++) {

			if (mem[n][j]) {
				min = Math.min(Math.abs(2 * j - sum), min);
			}

			System.out.print(String.format("%6d", Math.abs(2 * j - sum)));
		}
		System.out.println();
		System.out.println(min);

		return min;
	}

	public static void solution(int[] nums) {

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		int minDiff = Integer.MAX_VALUE;

		for (int i = 0; i <= sum; i++) {
			if (subsetSum(nums, nums.length, i)) {
				int sb = Math.abs(sum - i);
				minDiff = Math.min(minDiff, Math.abs(sb - i));
			}
		}

		System.out.println(minDiff);
	}

	public static boolean subsetSum(int[] nums, int n, int sum) {

		if (n == 0 && sum > 0) {
			return false;
		}

		if (sum == 0) {
			return true;
		}

		if (nums[n - 1] <= sum) {
			return subsetSum(nums, n - 1, sum - nums[n - 1]) || subsetSum(nums, n - 1, sum);
		}

		return subsetSum(nums, n - 1, sum);
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 6, 5, 11 }, 4);
	}

}
