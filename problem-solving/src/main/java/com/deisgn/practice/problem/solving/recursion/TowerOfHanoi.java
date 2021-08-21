package com.deisgn.practice.problem.solving.recursion;

public class TowerOfHanoi {

	private static String HANOI_PRINT_TEMPLATE = "Moving plate %d from tower %c to %c";

	public static void solution(char s, char d, char h, int n) {

		if (n == 1) {
			System.out.println(String.format(HANOI_PRINT_TEMPLATE, n, s, d));
			return;
		}
		
		solution(s, h, d, n-1);
		System.out.println(String.format(HANOI_PRINT_TEMPLATE, n, s, d));
		solution(h, d, s, n-1);
	}

	public static void main(String[] args) {
		//s - Source
		//d - Destination
		//a - Auxiliary
		solution('s', 'd', 'a', 2);
	}

}
