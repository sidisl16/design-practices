package com.deisgn.practice.problem.solving.arrays;

public class InversionOfArray {

	// using Merge sort
	public static void solution(int a[]) {

		int count = mergesort(a, 0, a.length - 1);
		System.out.println(count);
	}

	private static int mergesort(int[] a, int i, int j) {

		int count = 0;
		if (i < j) {
			int mid = (i + j) / 2;
			count += mergesort(a, i, mid);
			count += mergesort(a, mid + 1, j);
			count += merge(a, i, mid, j);
		}
		return count;
	}

	private static int merge(int[] a, int lb, int mid, int ub) {
		int i = lb;
		int j = mid + 1;
		int k = 0;
		int res[] = new int[(ub - lb) + 1];
		int count = 0;

		while (i <= mid && j <= ub) {

			if (a[i] <= a[j]) {
				res[k++] = a[i++];
			} else {
				res[k++] = a[j++];
				// In doubt
				count += (mid - (i - 1));
			}
		}

		while (i <= mid) {
			res[k++] = a[i++];
		}

		while (j <= ub) {
			res[k++] = a[j++];
		}

		i = 0;
		k = lb;

		while (k <= ub) {
			a[k++] = res[i++];
		}

		return count;
	}

	public static void main(String[] args) {
		int a[] = { 2, 4, 1, 3, 5 };
		solution(a);// 3
		int a1[] = { 9, 6, 8, 4 };
		solution(a1);// 5
	}

}
