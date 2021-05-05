package com.deisgn.practice.problem.solving.binary.search;

public class SearchInsertPosition {

	public static void solution(int[] nums, int target) {
		System.out.println(binarySearch(nums, target));
	}

	private static int binarySearch(int nums[], int target) {

		int low = 0;
		int high = nums.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else if (target > nums[mid]) {
				low = mid + 1;
			}
		}

		return low;
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 3, 5, 6 }, 2);
	}
}
