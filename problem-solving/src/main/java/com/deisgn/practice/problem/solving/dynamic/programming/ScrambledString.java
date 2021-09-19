package com.deisgn.practice.problem.solving.dynamic.programming;

public class ScrambledString {

	public static boolean solution(String a, String b, int i, int j) {

		if (i > j) {
			return false;
		}

		if (a.substring(i, j + 1).equals(b.substring(i, j + 1))) {
			return true;
		}

		boolean result = false;

		for (int k = i; k < j; k++) {
			result = (solution(a.substring(i, k), b.substring(i, k), i, k)
					|| solution(a.substring(k + 1, j), b.substring(k + 1, j), k + 1, j))
					&& (solution(a.substring(i, k), b.substring(j - 1, j - i + 1), i, k) && solution(a, b, k + 1, j));
		}

		return result;
	}

	public static void main(String[] args) {
		String a = "great";
		String b = "grate";
		System.out.println(solution(a, b, 0, a.length() - 1));
	}

}
