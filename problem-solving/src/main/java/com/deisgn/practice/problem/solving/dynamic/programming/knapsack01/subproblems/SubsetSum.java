package com.deisgn.practice.problem.solving.dynamic.programming.knapsack01.subproblems;

public class SubsetSum {

	public static boolean solution(int a[], int n, int sum) {

		boolean[][] mem = new boolean[n + 1][sum + 1];

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {

				if (j == 0) {
					mem[i][j] = Boolean.TRUE;
					continue;
				}

				if (i == 0) {
					mem[i][j] = Boolean.FALSE;
					continue;
				}

				if (a[i - 1] <= j) {

					mem[i][j] = mem[i-1][j - a[i - 1]] || mem[i - 1][j];

				} else {
					mem[i][j] = mem[i - 1][j];
				}

			}
		}

		print(mem, a);

		return mem[n][sum];
	}

	private static void print(boolean[][] mem, int[] a) {

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

	static boolean[][] mem;

	public static boolean recursive(int a[], int n, int sum) {

		if (n == 0 && sum > 0) {
			return false;
		}

		if (n == 0 && sum == 0) {
			return true;
		}

		if (mem[n][sum]) {
			return true;
		}

		if (a[n - 1] <= sum) {
			return (mem[n][sum] = recursive(a, n - 1, sum - a[n - 1]) || recursive(a, n - 1, sum));
		}

		return (mem[n][sum] = recursive(a, n - 1, sum));
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 7, 8, 10 };
		int sum = 14;
		boolean result = solution(a, a.length, sum);// true
		System.out.println(result);
		mem = new boolean[a.length + 1][sum + 1];
		result = recursive(a, a.length, sum);
		print(mem, a);
		System.out.println(result);
	}

}
