package com.deisgn.practice.problem.solving.recursion;

public class PrintSubsets {

	// Print powerset, subset or subsequence
	public static void printSubset(StringBuilder ip, String op) {
		if (ip.length() == 0) {
			System.out.println(op);
			return;
		}

		char ipForDecision = ip.charAt(0);
		ip.deleteCharAt(0);
		printSubset(ip, op);
		printSubset(ip, op + ipForDecision);
		ip.insert(0, ipForDecision);
	}

	public static void main(String[] args) {
		printSubset(new StringBuilder("abc"), "");
	}

}
