package com.deisgn.practice.problem.solving.dynamic.programming.lcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

	private static int maxCount = 1;

	// 2^n Time complexity
	public static void getCount(int[] nums, int n, List<Integer> list) {

		if (n == nums.length) {
			maxCount = Math.max(maxCount, list.size());
			return;
		}

		for (int i = n; i < nums.length; i++) {
			if (nums[i] >= list.get(list.size() - 1)) {

				list.add(nums[i]);

				getCount(nums, i + 1, list);

				// Backtrack
				list.remove(list.size() - 1);
			}
		}
	}


	public static void getCountDpLCS(int[] nums) {

		int[] nums2 = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i];
		}

		Arrays.sort(nums2);
		int maxLis = lcs(nums, nums2, nums.length, nums2.length);
		
		System.out.println(maxLis);
	}

	private static int lcs(int[] nums1, int[] nums2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}

		if (nums1[m - 1] == nums2[n - 1]) {
			return 1 + lcs(nums1, nums2, m - 1, n - 1);
		}

		return Math.max(lcs(nums1, nums2, m - 1, n), lcs(nums1, nums2, m, n - 1));

	}

	public static void main(String[] args) {
		List<Integer> op = new ArrayList<>();
		int[] ip = new int[] { 5, 8, 7, 1, 9 };
		op.add(ip[0]);
		getCount(ip, 1, op);
		System.out.println(maxCount);
		getCountDpLCS(new int[] { 50, 3, 10, 7, 40, 80 });
	}

}
