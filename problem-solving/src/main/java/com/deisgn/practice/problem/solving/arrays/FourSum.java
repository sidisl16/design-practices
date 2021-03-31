package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static void solution(int[] nums, int target) {

		Arrays.sort(nums);

		Set<List<Integer>> result = new HashSet<>();

		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {

				int l = j + 1;
				int r = nums.length - 1;

				while (l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];

					if (sum == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
					} else if (sum < target) {
						l++;
					} else if (sum > target) {
						r--;
					}
				}
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
	}
}
