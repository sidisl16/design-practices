package com.deisgn.practice.problem.solving.dynamic.programming.unbounded.knapsack.subproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	private static Boolean[][] memoization;

	private static Set<String> dictionary = new HashSet<>(Arrays.asList("mobile", "samsung", "sam", "sung", "man",
			"mango", "icecream", "and", "go", "i", "like", "ice", "cream"));

	public static boolean solution(String input, int i, int j) {

		if (input.isEmpty() || i > j) {
			return false;
		}

		if (memoization[i] != null && memoization[i][j] != null) {
			return memoization[i][j];
		}

		if (dictionary.contains(input.substring(i, j + 1))) {
			return true;
		}

		for (int k = i; k < j; k++) {
			if (solution(input, i, k) && solution(input, k + 1, j)) {
				return memoization[i][j] = true;
			}
		}
		return memoization[i][j] = false;
	}

	public static void main(String[] args) {
		String input = "samsungandmango";
		memoization = new Boolean[input.length() + 1][input.length() + 1];
		System.out.println(solution(input, 0, input.length() - 1));
	}

}
