package com.deisgn.practice.problem.solving.backtracking;

public class PrintAllCombinationOfString {

	public static void solution(StringBuilder s, int l) {

		if (l == s.length() - 1) {
			System.out.println(s.toString());
			return;
		}

		for (int i = l; i < s.length(); i++) {
			swap(s, l, i);
			solution(s, l + 1);
			swap(s, l, i);
		}
	}

	private static void swap(StringBuilder s, int l, int i) {
		char temp = s.charAt(l);
		s.setCharAt(l, s.charAt(i));
		s.setCharAt(i, temp);
	}

	public static void main(String[] args) {

		solution(new StringBuilder("ABC"), 0);

	}

}
