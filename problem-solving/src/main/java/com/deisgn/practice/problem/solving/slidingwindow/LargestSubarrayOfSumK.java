package com.deisgn.practice.problem.solving.slidingwindow;

public class LargestSubarrayOfSumK {

	private static void solution(int a[], int k) {

		int i = 0, j = 0, sum = 0;

		while (j < a.length) {
			sum += a[j];
			if (sum == k) {
				System.out.println(i + " " + j);
			} else if (sum > k) {
				while (sum > k) {
					sum -= a[i];
					i++;
				}
			}
			j++;
		}
	}

	public static void main(String[] args) {

		solution(new int[] { 4, 1, 1, 1, 2, 3, 5 }, 5);
	}

}
