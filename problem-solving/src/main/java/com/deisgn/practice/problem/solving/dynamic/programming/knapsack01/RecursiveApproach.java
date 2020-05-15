package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class RecursiveApproach implements Knapsack01 {

	@Override
	public int getMaxProfit(int[] weight, int[] profit, int bagWeight, int n) {

		// Base Condition
		if (n == 0 || bagWeight == 0) {
			// return 0 profit
			return 0;
		}

		if (weight[n - 1] > bagWeight) {
			// Don't include this item
			return getMaxProfit(weight, profit, bagWeight, n - 1);
		}

		// if (weight[n - 1] <= bagWeight)
		return Math.max(profit[n - 1] + getMaxProfit(weight, profit, bagWeight - weight[n - 1], n - 1),
				getMaxProfit(weight, profit, bagWeight, n - 1));
	}

}
