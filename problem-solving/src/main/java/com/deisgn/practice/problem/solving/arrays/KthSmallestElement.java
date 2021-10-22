package com.deisgn.practice.problem.solving.arrays;

public class KthSmallestElement {

	public static void solution(int a[], int k) {

		quicksort(a, 0, a.length - 1, k);

		System.out.println(a[k - 1]);

	}

	private static int quicksort(int[] a, int lb, int ub, int k) {

		if (lb < ub) {

			int loc = partition(a, lb, ub);

			if (loc == k - 1) {
				return loc;
			} else if (k - 1 < loc) {
				return quicksort(a, lb, loc, k);
			}
			return quicksort(a, loc + 1, ub, k);
		}
		return -1;
	}

	private static int partition(int[] a, int lb, int ub) {

		int pivot = a[lb];
		int i = lb;
		int j = ub;

		while (i < j) {

			while (i <= a.length - 1 && pivot >= a[i]) {
				i++;
			}

			while (j >= 0 && pivot < a[j]) {
				j--;
			}

			if (i < j) {
				swap(a, i, j);
			}
		}

		swap(a, lb, j);

		return j;

	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int a[] = { 7, 10, 4, 3, 20, 15 };

		solution(a, 3);// 7

		int a1[] = { 7, 10, 4, 20, 15 };

		solution(a1, 4);// 15
	}

}
