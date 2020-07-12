package com.deisgn.practice.problem.solving.stack;

public class TappingTheRainWater {

	public void solution(int height[]) {
		int n = height.length;
		int ans = 0;
		int[] lmax = new int[height.length];
		int[] rmax = new int[height.length];

		lmax[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			lmax[i] = Math.max(lmax[i - 1], height[i]);
		}

		rmax[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rmax[i] = Math.max(rmax[i + 1], height[i]);
		}

		for (int i = 0; i < height.length; i++) {
			ans += Math.min(lmax[i], rmax[i]) - height[i];
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new TappingTheRainWater().solution(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
	}
}
