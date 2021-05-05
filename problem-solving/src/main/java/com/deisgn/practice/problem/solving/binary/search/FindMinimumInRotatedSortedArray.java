package com.deisgn.practice.problem.solving.binary.search;

public class FindMinimumInRotatedSortedArray {

	public static int findMin(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else if (nums[mid] < nums[low]) {
				high = mid;
			} else {
				high--;
			}
		}
		return nums[low];
	}

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 1, 3, 5 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 4 }));
	}
}
