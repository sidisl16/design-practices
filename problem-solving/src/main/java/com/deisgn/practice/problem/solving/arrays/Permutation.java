package com.deisgn.practice.problem.solving.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

	private static List<List<Integer>> list = new ArrayList<>();

	public static void solution(int[] nums) {
		permutation(nums, 0);
		System.out.println(list);
	}

	private static void permutation(int[] nums, int cid) {
		if (cid == nums.length - 1) {
			list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			return;
		}

		for (int i = cid; i < nums.length; i++) {
			swap(nums, cid, i);
			permutation(nums, cid + 1);
			swap(nums, cid, i);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 2, 3 });
	}

}
