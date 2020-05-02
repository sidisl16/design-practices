package com.deisgn.practice.problem.solving.arrays;

public class ZigZagArray {

	public static void solution(int a[]) {

		int i = 0;
		int m = a.length;

		while (i < m) {

			int oddOrEvenIndex = i & 1;

			// for odd index
			if (oddOrEvenIndex == 1) {

				if (a[i] < a[i - 1]) {
					swap(a, i, i - 1);
				}

				if ((i < m-1) && (a[i] < a[i + 1])) {
					swap(a, i, i + 1);
				}
			}

			// for even index
			if (oddOrEvenIndex == 0) {

				if ((i > 0) && (a[i] > a[i - 1])) {
					swap(a, i, i - 1);
				}

				if ((i < m-1) && (a[i] > a[i + 1])) {
					swap(a, i, i + 1);
				}
			}
			
			i++;
		}

		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]+" ");
		}
	}

	private static void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int a[] = { 4, 3, 7, 8, 6, 2, 1 };

		solution(a);// 3 7 4 8 2 6 1

		System.out.println();

		int a1[] = { 1, 4, 3, 2 };

		solution(a1);// 1 4 2 3

	}

}
