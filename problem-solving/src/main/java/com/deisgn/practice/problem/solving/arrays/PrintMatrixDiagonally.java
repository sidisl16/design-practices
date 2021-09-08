package com.deisgn.practice.problem.solving.arrays;

public class PrintMatrixDiagonally {

	public static void printUpperBound(int[][] nums) {

		for (int g = nums.length - 1; g > 0; g--) {
			for (int i = g, j = 0; i < nums.length; i++, j++) {
				System.out.println(nums[i][j]);
			}
		}

		for (int g = 0; g < nums.length; g++) {
			for (int i = 0, j = g; j < nums.length; i++, j++) {
				System.out.println(nums[i][j]);
			}
		}
	}

	public static void printLowerBound(int[][] nums) {

		for (int g = 0; g < nums.length - 1; g++) {
			for (int i = g, j = 0; i >= 0; i--, j++) {
				System.out.println(nums[i][j]);
			}
		}

		for (int g = 0; g < nums.length; g++) {
			for (int i = nums.length - 1, j = g; j < nums.length; i--, j++) {
				System.out.println(nums[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		int nums[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// printUpperBound(nums); // 13,9,14,5,10,15,1,6,11,16,27,12,3,8,4
		printLowerBound(nums);
	}
}