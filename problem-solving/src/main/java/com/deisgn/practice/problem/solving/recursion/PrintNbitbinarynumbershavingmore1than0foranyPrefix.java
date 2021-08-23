package com.deisgn.practice.problem.solving.recursion;

public class PrintNbitbinarynumbershavingmore1than0foranyPrefix {

	public static void solution(int n, int o, int z, String op) {
		if (z > o) {
			return;
		}

		if (o + z == n) {
			System.out.println(op);
			return;
		}

		solution(n, o + 1, z, op + "1");
		solution(n, o, z + 1, op + "0");
	}

	public static void main(String[] args) {
		solution(5, 0, 0, "");
	}
}
