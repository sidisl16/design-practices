package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class TopDownApproach extends Knapsack01Template {

	public TopDownApproach(int n, int w) {
		super(n, w);
	}

	@Override
	protected int solution(int[] weight, int[] profit, int w, int n) {

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
		return mem[n][w];
	}

}
