package com.deisgn.practice.problem.solving.dynamic.programming.mcm;

public class MCM {

	public static int getMinCostRecursive(int a[], int i, int j) {

		int min = Integer.MAX_VALUE;

		if (i >= j) {
			return 0;
		}

		for (int k = i; k <= j - 1; k++) {
			int cost = getMinCostRecursive(a, i, k) + getMinCostRecursive(a, k + 1, j) + (a[i - 1] * a[k] * a[j]);
			min = Math.min(min, cost);
		}

		return min;
	}

	private static int mem[][] = new int[5][5];

	public static int getMinCostRecursiveMemoize(int a[], int i, int j) {

		int min = Integer.MAX_VALUE;

		if (i >= j) {
			return 0;
		}

		if (mem[i][j] != 0) {
			return mem[i][j];
		}

		for (int k = i; k < j; k++) {
			int cost = getMinCostRecursive(a, i, k) + getMinCostRecursive(a, k + 1, j) + (a[i - 1] * a[k] * a[j]);
			min = Math.min(min, cost);
		}

		return (mem[i][j] = min);
	}

	public static void main(String[] args) {

		int a[] = { 40, 20, 30, 10, 30 };
		System.out.println(getMinCostRecursive(a, 1, a.length - 1));
	}

}