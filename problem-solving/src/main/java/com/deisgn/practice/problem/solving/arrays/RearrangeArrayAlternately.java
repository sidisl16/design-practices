package com.deisgn.practice.problem.solving.arrays;

public class RearrangeArrayAlternately {

	public static void solutionWithExtraSpace(int a[]) {
		
		int i = 0;
		int k = 0;
		int j = a.length - 1;
		int b[] = new int[a.length];

		while (i < j) {
			b[k++] = a[j];
			b[k++] = a[i];
			j--;
			i++;			
		}
		if(a.length%2 != 0) {
			b[k] = a[i];
		}
		
		print(b);
	}
	
	
	public static void solutionWithoutExtraSpace(int a[]) {
		int m = a.length;
		for(int i=0; i<m-1; i=i+2) {
			
			int last = a[m-1];
			int j=m-2;
			
			while(j>=i) {
				a[j+1]=a[j];
				j--;
			}
			
			a[i] = last;
			
		}
		print(a);
	}

	private static void print(int a[]) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		solutionWithExtraSpace(a);// 6 1 5 2 4 3
		
		System.out.println();
		
		int a1[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110 };
		solutionWithExtraSpace(a1);// 110 10 100 20 90 30 80 40 70 50 60
		
		System.out.println();
		
		int a2[] = { 1, 2, 3, 4, 5, 6 };
		solutionWithoutExtraSpace(a2);// 6 1 5 2 4 3
		
		System.out.println();
		
		int a3[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110 };
		solutionWithoutExtraSpace(a3);// 110 10 100 20 90 30 80 40 70 50 60
	}
}
