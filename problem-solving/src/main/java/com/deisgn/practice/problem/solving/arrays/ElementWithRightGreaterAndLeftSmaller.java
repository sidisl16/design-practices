package com.deisgn.practice.problem.solving.arrays;

public class ElementWithRightGreaterAndLeftSmaller {

	public static void solution(int a[]) {

		int i = 1;
		int m = a.length;

		while (i < m) {

			int j = 0;
			int k = m - 1;

			while (a[j] < a[i]) {
				j++;
			}

			while (a[k] > a[i]) {
				k--;
			}

			// If it j&k reached i then all elements on left are small and right are greater
			// only if k is not pointing to last element
			if (j == i && k == i && k != m - 1) {
				System.out.println(a[i]);
				return;
			}

			i++;
		}

		System.out.println(-1);
	}

	public static void main(String[] args) {
		int a[] = { 4, 2, 5, 7 };

		solution(a);// 5

		int a1[] = { 11, 9, 12 };

		solution(a1);// -1

		int a2[] = { 4, 3, 2, 7, 8, 9 };

		solution(a2);// 7
	}
}
