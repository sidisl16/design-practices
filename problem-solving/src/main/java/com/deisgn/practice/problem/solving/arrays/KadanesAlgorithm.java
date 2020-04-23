package com.deisgn.practice.problem.solving.arrays;

public class KadanesAlgorithm {

	public static void solution(int a[]) {
		int max = -Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i=0; i<a.length; i++) {
			sum = sum + a[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, -2, 5 };
		solution(a);//9

		int a2[] = { -1, -2, -3, -4 };
		solution(a2);//-1
	}
}
