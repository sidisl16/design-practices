package com.deisgn.practice.problem.solving.recursion;

public class PermutationWithCaseChange {

	public static void solution(StringBuilder ip, String op) {
		if (ip.isEmpty()) {
			System.out.println(op);
			return;
		}

		char ch = ip.charAt(0);
		ip.deleteCharAt(0);
		solution(ip, op + ch);
		solution(ip, op + Character.toUpperCase(ch));
		ip.insert(0, ch);
	}

	public static void main(String[] args) {
		solution(new StringBuilder("ab"), "");
	}
}
