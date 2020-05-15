package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class RecursiveMemoizationApproach implements Knapsack01 {

	private RecursiveApproach2 recursiveApproach2;

	public RecursiveMemoizationApproach(int w, int n) {
		recursiveApproach2 = new RecursiveApproach2(w, n);
	}

	@Override
	public int getMaxProfit(int[] weight, int[] profit, int w, int n) {
		int maxProfite = recursiveApproach2.getMaxProfit(weight, profit, w, n);
		recursiveApproach2.print();
		return maxProfite;
	}
}
