package com.deisgn.practice.problem.solving.slidingwindow;

public class MaxSumOfKwindow {

	private static void solution(int a[], int k) {
		int i = 0, j = 0, sum = 0;
		int max = Integer.MIN_VALUE;
		while (j < a.length) {
			sum += a[j];
			if ((j - i + 1) < k) {
				j++;
			} else if ((j - i + 1) == k) {
				max = Math.max(sum, max);
				sum -= a[i];
				i++;
				j++;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		solution(new int[] { 5, 7, 2, 3, 8, 25 }, 4);
	}
}
