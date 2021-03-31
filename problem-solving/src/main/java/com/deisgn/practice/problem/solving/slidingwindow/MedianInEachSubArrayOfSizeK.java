package com.deisgn.practice.problem.solving.slidingwindow;

import java.util.Arrays;

public class MedianInEachSubArrayOfSizeK {

	public static void solution(int[] nums, int k) {
		int i = 0, j = 0, l = 0, p = 0;
		double[] median = new double[nums.length - k + 1];
		boolean isEven = k % 2 == 0 ? true : false;

		while (j < nums.length) {

			if ((j - i + 1) == k) {
				median[l++] = getMedian(nums, i, j, isEven);
				i++;
			}

			j++;
		}

		for (double n : median) {
			System.out.println(n);
		}
	}

	private static double getMedian(int[] a, int i, int j, boolean even) {
		int[] copied = Arrays.copyOfRange(a, i, j + 1);
		Arrays.sort(copied);
		int mid = (copied.length - 1) / 2;
		if (even) {
			return ((double)copied[mid] + copied[mid + 1]) / 2;
		}
		return copied[mid];
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);// 1,-1,-1,3,5,6

		solution(new int[] { 1, 4, 2, 3 }, 4);
	}

}