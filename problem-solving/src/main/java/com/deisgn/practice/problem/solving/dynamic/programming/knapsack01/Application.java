package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class Application {

	public static void main(String[] args) {

		int[] weight = { 1, 3, 4, 5 };
		int[] profit = { 1, 4, 5, 7 };
		int bagWeight = 7;
		int n = weight.length;

		Knapsack01Strategy solution = new Knapsack01Strategy(new RecursiveApproach());
		System.out.println(solution.getMaxProfit(weight, profit, bagWeight, n));

		Knapsack01Strategy solution1 = new Knapsack01Strategy(new RecursiveMemoizationApproach(bagWeight, n));
		System.out.println(solution1.getMaxProfit(weight, profit, bagWeight, n));

	}
}
