package com.deisgn.practice.problem.solving.slidingwindow;

import java.util.LinkedList;

public class FirstNegativeNoInWindow {

	private static void solution(int a[], int k) {

		int j = 0, i = 0;
		LinkedList<Integer> list = new LinkedList<>();
		while (j < a.length) {

			if (a[j] < 0) {
				list.add(a[j]);
			}

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (list.peek() != null) {
					System.out.println(list.peek());
					if (list.peek() == a[i]) {
						list.remove();
					}
				} else {
					System.out.println(0);
				}
				i++;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		solution(new int[] { -8, 2, 3, -6, 10 }, 2); // -8 0 -6 -6
	}

}
