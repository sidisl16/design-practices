package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class TopDownApproach implements Knapsack01 {

	/**
	 * Converting recursive to top down approach
	 */
	@Override
	public int getMaxProfit(int[] weight, int[] profit, int w, int n) {
		// all initialized with 0's
		int[][] mem = new int[n + 1][w + 1];

		// i -> n(size(profit and weight)), j -> w
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (weight[i - 1] <= j) {

					// Math.max(profit[n - 1] + getMaxProfit(weight, profit, bagWeight - weight[n -
					// 1], n - 1),
					// getMaxProfit(weight, profit, bagWeight, n - 1))
					mem[i][j] = Math.max(profit[i - 1] + mem[i - 1][j - weight[i - 1]], mem[i - 1][j]);

				} else {
					// if weight[i - 1] > w
					// getMaxProfit(weight, profit, w, n - 1);
					mem[i][j] = mem[i - 1][j];
				}
			}
		}
		print(mem);
		return mem[n][w];
	}

	public void print(int mem[][]) {
		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {
				System.out.print(mem[i][j] + " ");
			}
			System.out.println();
		}
	}

}
