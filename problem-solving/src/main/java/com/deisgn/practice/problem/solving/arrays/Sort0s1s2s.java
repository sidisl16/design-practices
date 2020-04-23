package com.deisgn.practice.problem.solving.arrays;

public class Sort0s1s2s {

	public static void solution(int[] a) {

		int low = 0;
		int mid = 0;
		int high = a.length - 1;

		while (mid < high) {

			if (a[mid] == 0) {
				swap(a, mid, low);
				mid++;
				low++;
			} else if (a[mid] == 2) {
				swap(a, mid, high);
				high--;
			} else {
				mid++; // if mid is 1
			}

		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 0, 2, 1, 2, 0 };
		solution(a);
		System.out.println();

		int[] a1 = { 1, 0, 2, 2, 1, 0 };
		solution(a1);

		System.out.println();
		int[] a2 = { 2, 0, 1, 0, 2, 2 };
		solution(a2);
	}
}
