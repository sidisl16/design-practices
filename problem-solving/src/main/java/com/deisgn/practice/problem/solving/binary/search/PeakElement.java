package com.deisgn.practice.problem.solving.binary.search;

public class PeakElement {

	public static int solution(int[] nums) {

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (mid > 0 && mid < nums.length - 1) {
				if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
					return mid;
				} else if (nums[mid] > nums[mid - 1]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (mid == 0) {
				if (nums[mid] > nums[mid + 1]) {
					return mid;
				} else {
					return mid + 1;
				}
			} else {
				if (nums[mid] > nums[mid - 1]) {
					return mid;
				} else {
					return mid - 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 1 }));
	}
}
