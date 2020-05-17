package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01.subproblems;

public class CountOfSubsetSum {

	public static int solution(int[] a, int n, int sum) {

		int[][] mem = new int[n + 1][sum + 1];

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {

				if (j == 0) {
					mem[i][j] = 1;
					continue;
				}

				if (i == 0) {
					mem[i][j] = 0;
					continue;
				}

				if (a[i - 1] <= j) {

					mem[i][j] = mem[i - 1][j - a[i - 1]] + mem[i - 1][j];

				} else {

					mem[i][j] = mem[i - 1][j];

				}

			}
		}

		print(mem, a);
		return mem[n][sum];
	}

	private static void print(int[][] mem, int[] a) {

		for (int j = 0; j < mem[0].length; j++) {
			System.out.print((j == 0 ? "      " : "") + "|" + String.format("%6d", j) + "| | ");
		}

		System.out.println();

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {
				System.out.print((j == 0 ? String.format("%2d", (i == 0 ? 0 : a[i - 1])) : "") + " | "
						+ (j == 0 ? i : "") + "|" + String.format("%6s", mem[i][j]) + "|");
			}
			System.out.println();
			System.out.println(
					"--------------------------------------------------------------------------------------------------------------------------------------");

		}

	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 5, 6, 8, 10 };
		int sum = 10;

		System.out.println(solution(a, a.length, sum)); // 3
	}

}
