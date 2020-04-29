package com.deisgn.practice.problem.solving.arrays;

public class TrappingTheWater {

	public static void solutionApproach1(int[] a) {

		// Using extra space o(n)
		int[] lmax = new int[a.length];
		int[] rmax = new int[a.length];

		lmax[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			lmax[i] = Math.max(lmax[i - 1], a[i]);
		}

		rmax[a.length - 1] = a[a.length - 1];

		for (int i = a.length - 2; i >= 0; i--) {
			rmax[i] = Math.max(a[i], rmax[i + 1]);
		}

		int total_water = 0;

		for (int i = 0; i < a.length; i++) {
			int water_building = Math.min(lmax[i], rmax[i]);
			total_water += water_building - a[i];
		}

		System.out.println(total_water);

	}

	public static void solutionApproach2(int[] a) {

		// Not using extra space o(1)
		int total_water = 0;

		int i = 0;
		int j = a.length - 1;

		int lmax = a[0];
		int rmax = a[a.length - 1];

		while (i <= j) {

			lmax = Math.max(lmax, a[i]);
			rmax = Math.max(rmax, a[j]);

			if (lmax <= rmax) {
				total_water += lmax - a[i];
				i++;
			} else if (rmax <= lmax) {
				total_water += rmax - a[j];
				j--;
			}
		}
		System.out.println(total_water);
	}

	public static void main(String[] args) {

		int a[] = { 3, 0, 0, 2, 0, 4 };

		solutionApproach1(a);// 10

		int a1[] = { 7, 4, 0, 9 };

		solutionApproach1(a1);// 10

		int a2[] = { 6, 9, 9 };

		solutionApproach1(a2);// 0

		solutionApproach2(a);// 10
		solutionApproach2(a1);// 10
		solutionApproach2(a2);// 0

	}

}
