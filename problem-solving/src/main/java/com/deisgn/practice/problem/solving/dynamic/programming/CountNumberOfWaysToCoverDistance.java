package com.deisgn.practice.problem.solving.dynamic.programming;

public class CountNumberOfWaysToCoverDistance {

	private static int[] memozation;

	public static int getNoOfWays(int n) {

		if (n == 0) {
			return 1;
		}

		if (n < 0) {
			return 0;
		}

		if (memozation[n] > 0) {
			return memozation[n];
		}

		return (memozation[n] = getNoOfWays(n - 1) + getNoOfWays(n - 2) + getNoOfWays(n - 3));
	}

	public static void main(String[] args) {
		int distance = 3;
		memozation = new int[distance + 1];
		System.out.println(getNoOfWays(distance));

	}

}
