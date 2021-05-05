package com.deisgn.practice.problem.solving.binary.search;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

	public static void solution(int[] nums, int target) {
		int first = binarySearch(nums, target, true);

		if (first == -1) {
			System.out.println(Arrays.toString(new int[] { -1, -1 }));
		}
		int last = binarySearch(nums, target, false);

		System.out.println(Arrays.toString(new int[] { first, last }));
	}

	private static int binarySearch(int nums[], int target, boolean isFirst) {

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == nums[mid]) {

				if (isFirst) {
					if (mid == low || target != nums[mid - 1]) {
						return mid;
					}

					high = mid - 1;
				} else {

					if (mid == high || target != nums[mid + 1]) {
						return mid;
					}

					low = mid + 1;

				}

			} else if (target < nums[mid]) {
				high = mid - 1;
			} else if (target > nums[mid]) {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		solution(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
	}

}
