package com.deisgn.practice.problem.solving.dynamic.programming.mcm;

public class PallimdromePartition {

	private static int mem[][] = new int[1000][1000];

	// Recursive - bottom up approach
	public static int getCost(String s, int i, int j) {

		int min = Integer.MAX_VALUE;

		if (i >= j) {
			return 0;
		}

		if (mem[i][j] != 0) {
			return mem[i][j];
		}

		if (isPallimdrome(s, i, j)) {
			return 0;
		}

		for (int k = i; k < j; k++) {

			int tempAns = getCost(s, i, k) + getCost(s, k + 1, j) + 1;
			min = Math.min(min, tempAns);
		}

		return (mem[i][j] = min);
	}

	// Recursive - bottom up approach optimized
	public static int getCostOptimised(String s, int i, int j) {

		int min = Integer.MAX_VALUE;

		if (i >= j) {
			return 0;
		}

		if (mem[i][j] != 0) {
			return mem[i][j];
		}

		if (isPallimdrome(s, i, j)) {
			return 0;
		}

		for (int k = i; k < j; k++) {

			int tempAns = (mem[i][k] != 0 ? mem[i][k] : getCost(s, i, k))
					+ (mem[k + 1][j] != 0 ? mem[k + 1][j] : getCost(s, k + 1, j)) + 1;
			min = Math.min(min, tempAns);
		}

		return (mem[i][j] = min);
	}

	private static boolean isPallimdrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "madam";
		System.out.println(getCostOptimised(s, 0, s.length() - 1));

		mem = new int[1000][1000];

		String s1 = "cabcbaa";
		System.out.println(getCostOptimised(s1, 0, s1.length() - 1));
	}

}
