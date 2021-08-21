package com.deisgn.practice.problem.solving.recursion;

public class KthSymbolInGrammar {

	public static int solution(int n, int k) {

		if (n == 1 && k == 1) {
			return 0;
		}

		int mid = (int) Math.pow(2, n - 1);

		if (k <= mid) {
			return solution(n - 1, k) == 0 ? 0 : 1;
		}

		return solution(n - 1, k - mid) == 0 ? 1 : 0;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, 6));
	}
}
