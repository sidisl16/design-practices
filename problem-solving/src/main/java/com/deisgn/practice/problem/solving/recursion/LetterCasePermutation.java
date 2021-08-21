package com.deisgn.practice.problem.solving.recursion;

public class LetterCasePermutation {

	public static void solution(StringBuilder ip, String op) {
		if (ip.isEmpty()) {
			System.out.println(op);
			return;
		}

		char ch = ip.charAt(0);
		ip.deleteCharAt(0);

		if (Character.isDigit(ch)) {
			solution(ip, op + ch);
		} else {
			solution(ip, op + Character.toLowerCase(ch));
			solution(ip, op + Character.toUpperCase(ch));
		}
		ip.insert(0, ch);
	}

	public static void main(String[] args) {
		solution(new StringBuilder("a1B2"), "");
	}
}
