package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public class RecursiveMemoizationApproach extends RecursiveApproach2 {

	public RecursiveMemoizationApproach(int w, int n) {
		super(w, n);
	}

	@Override
	public int getMaxProfit(int[] weight, int[] profit, int w, int n) {
		int maxProfite = super.getMaxProfit(weight, profit, w, n);
		print();
		return maxProfite;
	}

	private void print() {
		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {
				System.out.print(mem[i][j] + " ");
			}
			System.out.println();
		}

	}

}
