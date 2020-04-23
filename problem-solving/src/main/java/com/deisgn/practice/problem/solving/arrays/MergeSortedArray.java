package com.deisgn.practice.problem.solving.arrays;

public class MergeSortedArray {
	
	public static void solution(int a[], int b[]) {
		int m = a.length;
		int n = b.length;
		int res[] = new int[m+n];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < m && j < n) {
			
			if(a[i] <= b[j]) {
				res[k++] = a[i++];
			} else {
				res[k++] = b[j++];
			}
			
		}
		
		while( i < m && k < m+n) {
			res[k++] = a[i++];
		}
		
		while( j < n && k < m+n) {
			res[k++] = b[j++];
		}
		
		for(int q=0; q<m+n; q++) {
			System.out.print(res[q]+" ");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int a[] = {1, 3, 5, 7};
		int b[] = {0, 2, 6, 8, 9};
		
		solution(a, b);//0 1 2 3 5 6 7 8 9
		
		System.out.println();
		
		int a1[] = {10, 12};
		int b2[] = {5, 18, 20};
		
		solution(a1, b2);//5 10 12 18 20
	}
}
