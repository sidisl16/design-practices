package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;

public class ChoclateDistribution {

	public static void solution(int a[], int m) {

		Arrays.sort(a);

		int i = 0;
		int j = i + m - 1;
		int min = a[j] - a[i];

		while (j <= a.length - 1) {

			min = Math.min(min, (a[j] - a[i]));
			i++;
			j = i + m - 1;

		}

		System.out.println(min);
	}

	public static void main(String[] args) {

		int a[] = { 3, 4, 1, 9, 56, 7, 9, 12 };

		solution(a, 5);// 6

		int a1[] = { 7, 3, 2, 4, 9, 12, 56 };

		solution(a1, 3);//2
	}
}
