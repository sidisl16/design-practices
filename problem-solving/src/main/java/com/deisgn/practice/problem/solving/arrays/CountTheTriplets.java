package com.deisgn.practice.problem.solving.arrays;

import java.util.Set;
import java.util.TreeSet;

public class CountTheTriplets {

	public static void solution(int a[]) {

		int k = 0;
		int res = 0;

		Set<Integer> set = new TreeSet<>();
		while (k < a.length) {
			set.add(a[k++]);
		}

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length; j++) {
				if (set.contains(a[i] + a[j]) && i < j) {
					res++;
				}
			}

		}

		if (res == 0) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 5, 3, 2 };
		solution(a);//2

		int a1[] = { 3, 2, 7 };
		solution(a1);//-1
	}
}
