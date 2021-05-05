package com.deisgn.practice.problem.solving.binary.search;

import java.util.Arrays;

public class SearchinRotatedSortedArray {

	public static void solution(int[] nums, int target) {

		int res = -1;

		if (nums[0] < nums[nums.length - 1]) {
			res = Arrays.binarySearch(nums, 0, nums.length, target);
		} else {
			int pivot = getPivot(nums);
				res = Arrays.binarySearch(nums, pivot, nums.length, target);
				if(res < 0) {
					res = Arrays.binarySearch(nums, 0, pivot + 1, target);
				}
				
		}
		if (res < 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(res);
	}

	private static int getPivot(int[] nums) {

		if (nums.length == 1) {
			return 0;
		}

		int start = 0;
		int end = nums.length - 1;
		int n = nums.length;
		while (start <= end) {

			int mid = (start + end) / 2;

			int prev = (mid + n - 1) % n;
			int next = (mid + 1) % n;

			if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
				return mid;
			} else if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		solution(new int[] { 1 }, 0);
		//solution(new int[] { 1, 3 }, 0);
		//solution(new int[] { 1, 3 }, 3);
		solution(new int[] { 5, 1, 3 }, 3);
		solution(new int[] { 3, 1 }, 0);
		solution(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0);
		solution(new int[] { 4, 6, 7, 8, 0, 1, 3 }, 6);
		solution(new int[] { 4, 6, 7, 8, 0, 1, 2, 3 }, 6);
	}

}