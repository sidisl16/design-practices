package com.deisgn.practice.problem.solving.arrays;

import java.util.Stack;

public class LeadersInAnArray {

	public static void solution(int a[]) {
		Stack<Integer> result = new Stack<>();
		int m = a.length - 1;
		int max = a[m];

		for (int i = a.length - 1; i >= 0; i--) {

			if (a[i] >= max) {
				max = a[i];
				result.push(max);
			}
		}

		while (!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
	}

	public static void main(String[] args) {

		int a[][] = new int[3][];

		a[0] = new int[] { 16, 17, 4, 3, 5, 2 };
		a[1] = new int[] { 1, 2, 3, 4, 0 };
		a[2] = new int[] { 7, 4, 5, 7, 3 };

		for (int i = 0; i < a.length; i++) {
			solution(a[i]);
			System.out.println();
		}
		/**
		 * 17 5 2 4 0 7 7 3
		 */

	}
}
