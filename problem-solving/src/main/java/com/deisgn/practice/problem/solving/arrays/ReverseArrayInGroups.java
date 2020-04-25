package com.deisgn.practice.problem.solving.arrays;

public class ReverseArrayInGroups {

	public static void solution(int a[], int k) {
		
		int m = a.length - 1;

		for (int i = 0; i <= m; i = i + k) {
			reverse(a, i, Math.min(m, (i + k - 1)));
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void reverse(int a[], int i, int j) {
		
		while (i < j) {

			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;

			i++;
			j--;
		}
	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5 };
		int k = 3;

		solution(a, k);// 3 2 1 5 4

		System.out.println();

		int a1[] = { 10, 20, 30, 40, 50, 60 };
		k = 2;

		solution(a1, k);// 20 10 40 30 60 50
	}

}
