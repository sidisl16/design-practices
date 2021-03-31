package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void solution(int[] nums, int target) {
		int result = 0;
		int diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {

			int l = i + 1;
			int r = nums.length - 1;

			while (l < r) {

				int sum = nums[i] + nums[l] + nums[r];

				if (sum == target) {
					System.out.println(sum);
					return;
				}

				if (diff > Math.abs(sum - target)) {
					result = sum;
					diff = Math.abs(sum - target);
				}

				if (sum > target) {
					r--;
				} else if (sum < target) {
					l++;
				}
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		solution(new int[] { -1, 2, 1, -4 }, 1);// 2
		solution(new int[] { 0, 1, 2 }, 3);// 2
	}
}
