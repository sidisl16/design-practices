package com.deisgn.practice.problem.solving.dynamic.programming;

import java.util.Arrays;

public class Fibonacci {

	private static int[] lookup;

	public static int fibMemoization(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (lookup[n] == 0) {
			lookup[n] = fibMemoization(n - 1) + fibMemoization(n - 2);
		}
		return lookup[n];
	}

	public static int fibTabulation(int n) {
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		System.out.println(Arrays.toString(fib));
		return fib[n];
	}

	public static void main(String[] args) {
		int n = 9;
		lookup = new int[n + 1];
		System.out.println(fibMemoization(n));

		System.out.println(fibTabulation(n));
	}
}