package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormedFromAnArray {

	public static void solution(Integer a[]) {

		Arrays.sort(a, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				Integer a = Integer.parseInt(String.valueOf(o2) + o1);
				Integer b = Integer.parseInt(String.valueOf(o1) + o2);
				return a.compareTo(b);
			}
		});

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}

	public static void main(String[] args) {

		Integer a[] = { 3, 30, 34, 5, 9 };
		solution(a);// 9534330

		System.out.println();

		Integer a1[] = { 54, 546, 548, 60 };
		solution(a1);// 6054854654
	}

}
