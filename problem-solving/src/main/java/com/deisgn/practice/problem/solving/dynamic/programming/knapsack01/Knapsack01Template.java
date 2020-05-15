package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01;

public abstract class Knapsack01Template implements Knapsack01 {

	protected int mem[][];

	public Knapsack01Template(int n, int w) {
		mem = new int[n + 1][w + 1];
	}

	protected abstract int solution(int[] weight, int[] profit, int w, int n);

	protected void print() {
		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {
				System.out.print(mem[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Override
	public int getMaxProfit(int[] weight, int[] profit, int w, int n) {
		int maxprofit = solution(weight, profit, w, n);
		print();
		return maxprofit;
	}

}
