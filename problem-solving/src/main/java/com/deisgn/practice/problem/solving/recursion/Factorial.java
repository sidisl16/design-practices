package com.deisgn.practice.problem.solving.recursion;

public class Factorial {

	
	public static int solution(int n) {
		
		// base condition
		if (n == 0 || n == 1) {
			return 1;
		}

		// Hypothesis
		int fact = solution(n - 1);

		// Induction
		return fact * n;
	}

	public static void main(String[] args) {
		System.out.println(solution(5));
	}
}
