package com.deisgn.practice.problem.solving.arrays;

public class KthSmallestElement {

	public static void solution(int a[], int k) {

		int res = quicksort(a, 0, a.length - 1, k);
		System.out.println(res);
	}

	private static int quicksort(int[] a, int lb, int ub, int k) {

		if (lb < ub) {
			int loc = partition(a, lb, ub);
			
			if (loc == k-1) {
				return a[loc];
			}
			
			if (loc < k-1)
				return quicksort(a, lb, loc - 1, k);
			
			return quicksort(a, loc + 1, ub, k);
		}

		return -1;
	}

	private static int partition(int[] a, int lb, int ub) {

		int start = lb;
		int end = ub;
		int pivot = a[lb];

		while (start < end) {

			while (a[start] <= pivot && start < a.length - 1) {
				start++;
			}

			while (a[end] > pivot && end >= 0) {
				end--;
			}

			if (start < end) {
				swap(a, start, end);
			}
		}

		swap(a, lb, end);

		return end;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int a[] = { 7, 10, 4, 3, 20, 15 };

		solution(a, 3);// 7
	}

}
