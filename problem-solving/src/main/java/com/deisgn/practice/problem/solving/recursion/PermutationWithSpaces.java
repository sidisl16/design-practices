package com.deisgn.practice.problem.solving.recursion;

public class PermutationWithSpaces {

	public static void solution(StringBuilder ip, String op) {

		if (ip.length() == 0) {
			System.out.println(op.toString());
			return;
		}
		
		char ch = ip.charAt(0);
		ip.deleteCharAt(0);
		solution(ip, op + ch);
		solution(ip, op + "_" + ch);
		ip.insert(0, ch);
	}

	public static void main(String[] args) {
		String ip = "ABC";
		solution(new StringBuilder(ip.substring(1)), String.valueOf(ip.charAt(0)));
	}

}
