package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class RecursiveApproach2 implements Knapsack01 {

	protected static int[][] mem;

	public RecursiveApproach2(int w, int n) {
		mem = new int[n + 1][w + 1];
	}

	@Override
	public int getMaxProfit(int[] weight, int[] profit, int w, int n) {

		if (n == 0 || w == 0) {
			return 0;
		}

		if (mem[n][w] != 0) {
			return mem[n][w];
		}

		if (weight[n - 1] > w) {
			return (mem[n][w] = getMaxProfit(weight, profit, w, n - 1));
		}

		return (mem[n][w] = Math.max(profit[n - 1] + getMaxProfit(weight, profit, w - weight[n - 1], n - 1),
				getMaxProfit(weight, profit, w, n - 1)));
	}
}
