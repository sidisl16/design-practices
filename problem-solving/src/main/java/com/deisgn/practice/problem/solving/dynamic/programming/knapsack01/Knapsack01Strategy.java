package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class Knapsack01Strategy implements Knapsack01 {

	private Knapsack01 strategy;

	public Knapsack01Strategy(Knapsack01 strategy) {
		this.strategy = strategy;
	}

	@Override
	public int getMaxProfit(int[] weight, int[] profit, int bagWeight, int n) {
		return strategy.getMaxProfit(weight, profit, bagWeight, n);
	}

}
