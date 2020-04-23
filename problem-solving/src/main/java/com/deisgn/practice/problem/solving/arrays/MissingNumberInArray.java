package com.deisgn.practice.problem.solving.arrays;

public class MissingNumberInArray {

	public static void solution(int a[]) {
		int i = 0;
		int j = 1;
		while (i < j && j < a.length) {
			if (a[j] - a[i] > 1) {
				System.out.println(a[i] + 1);
				return;
			}
			i++;
			j++;
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 5 };
		solution(a);// 4

		int a2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		solution(a2);// 9
	}
}
