package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;

public class MinimumPlatforms {

	public static void solution(int[] arr, int[] dep) {

		Arrays.sort(arr);
		Arrays.sort(dep);

		int ans = 1;
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			if (dep[j] > arr[i]) {
				ans++;
				continue;
			}
			j++;
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) {

		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

		solution(arr, dep);
	}
}