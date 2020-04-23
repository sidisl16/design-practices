package com.deisgn.practice.problem.solving.arrays;

public class MergeSortedArrayWithoutExtraSpace {

	/** Insertion sort
	 *  
	 *  for (int j = 1; j < a.length; j++) {

		int i = j - 1;

		int temp = a[j];

			while (i >= 0 && (temp <= a[i])) {
				i--;
			}

			a[i + 1] = temp;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	 *  
	 */
	public static void solution(int a[], int b[]) {

		int m = a.length;
		int n = b.length;

		for (int i = n - 1; i >= 0; i--) {

			int j = m - 2;
			int last = a[m - 1];

			while (j >= 0 && b[i] <= a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			
			if (j != (m - 2) || last > b[i]) {
				a[j+1] = b[i];
				b[i] = last;
			}
		}

		print(a, b);

	}
	
	private static void print(int a[], int b[]) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}

	public static void main(String[] args) {

		int a[] = { 1, 3, 5, 7 };
		int b[] = { 0, 2, 6, 8, 9 };

		solution(a, b);// 0 1 2 3 5 6 7 8 9

		System.out.println();

		int a1[] = { 10, 12 };
		int b2[] = { 5, 18, 20 };

		solution(a1, b2);// 5 10 12 18 20
		
		System.out.println();

		int a3[] = { 1, 5, 9, 10, 15, 20 };
		int b3[] = { 2, 3, 8, 13 };
		
		solution(a3, b3);
		
		System.out.println();
		
		int a4[] = {10};
		int b4[] = {2, 3};
		
		solution(a4, b4);
		
	}
}
