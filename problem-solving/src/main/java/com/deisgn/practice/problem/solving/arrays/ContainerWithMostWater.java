package com.deisgn.practice.problem.solving.arrays;

public class ContainerWithMostWater {

	public static void solution(int[] height) {
		int i = 0, j = height.length - 1;
		int maxarea = 0;

		while (i != j) {

			maxarea = Math.max(maxarea, (j - i) * Math.min(height[i], height[j]));

			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}

		System.out.println(maxarea);
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
		solution(new int[] { 1, 1 });
		solution(new int[] { 4, 3, 2, 1, 4 });
		solution(new int[] { 1, 2, 1 });
	}
}
