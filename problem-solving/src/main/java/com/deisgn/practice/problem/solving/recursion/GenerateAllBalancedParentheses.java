package com.deisgn.practice.problem.solving.recursion;

public class GenerateAllBalancedParentheses {

	public static void solution(int o, int c, String brackets) {
		if (o == 0 && c == 0) {
			System.out.println(brackets);
			return;
		}

		if (o != 0) {
			solution(o - 1, c, brackets + "(");
		}

		if (c > o) {
			solution(o, c - 1, brackets + ")");
		}
	}

	public static void main(String[] args) {
		solution(2, 3, "(");
	}

}
