package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class RecursiveMemoizationApproach extends Knapsack01Template {

	public RecursiveMemoizationApproach(int n, int w) {
		super(n, w);
	}

	@Override
	protected int solution(int[] weight, int[] profit, int w, int n) {

		if (n == 0 || w == 0) {
			return 0;
		}

		if (mem[n][w] != 0) {
			return mem[n][w];
		}

		if (weight[n - 1] > w) {
			return (mem[n][w] = solution(weight, profit, w, n - 1));
		}

		return (mem[n][w] = Math.max(profit[n - 1] + solution(weight, profit, w - weight[n - 1], n - 1),
				solution(weight, profit, w, n - 1)));
	}
}
