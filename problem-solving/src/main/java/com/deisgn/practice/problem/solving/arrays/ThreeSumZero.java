package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumZero {

	public static void solution(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		if(nums == null || nums.length < 3) {
			return;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {

			int l = i + 1;
			int r = nums.length - 1;

			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
				} else if (sum > 0) {
					r--;
				} else if (sum < 0) {
					l++;
				}
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		solution(new int[] { -1, 0, 1, 2, -1, -4 });
	}
}
