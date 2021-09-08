package com.deisgn.practice.problem.solving.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void solution(int[] nums) {

		sort(nums, 0, nums.length - 1);

		System.out.println(Arrays.toString(nums));
	}

	private static void sort(int[] nums, int l, int h) {

		if (l < h) {
			int pivotIndex = partition(nums, l, h);

			sort(nums, l, pivotIndex - 1);
			sort(nums, pivotIndex + 1, h);
		}
	}

	private static int partition(int[] nums, int l, int h) {

		int pivot = nums[l];
		int i = l;
		int j = h;
		while (i < j) {

			while (i <= h && pivot >= nums[i]) {
				i++;
			}

			while (j >= l && pivot < nums[j]) {
				j--;
			}

			if (i < j) {
				swap(nums, i, j);
			}
		}

		swap(nums, l, j);
		return j;
	}

	private static void swap(int[] nums, int l, int h) {
		int temp = nums[l];
		nums[l] = nums[h];
		nums[h] = temp;
	}

	public static void main(String[] args) {
		solution(new int[] { 5, 3, 2, 7, 1, 6 });
	}

}
