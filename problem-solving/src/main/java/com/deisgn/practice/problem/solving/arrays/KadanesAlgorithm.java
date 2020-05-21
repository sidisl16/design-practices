package com.deisgn.practice.problem.solving.arrays;

public class KadanesAlgorithm {

	public static int getMaxSum(int[] a, int n) {

		//Using DP
		int local_max = a[0];
		int max = a[0];

		for (int i = 1; i < n; i++) {
			local_max = Math.max(local_max + a[i], a[i]);
			max = Math.max(local_max, max);
		}

		return max;
	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, -2, 5 };
		
		System.out.println(getMaxSum(a, a.length));// 9
		
		int a2[] = { -1, -2, -3, -4 };
		System.out.println(getMaxSum(a2, a2.length));// -1
	}
}
