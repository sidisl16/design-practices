package com.deisgn.practice.problem.solving.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxOffAllSubArrayOfSizeK {

	private static void solution(int a[], int k) {

		int i = 0, j = 0;
		LinkedList<Integer> list = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		while (j < a.length) {

			while (!list.isEmpty() && a[j] > list.getLast()) {
				list.removeLast();
			}

			list.add(a[j]);

			if ((j - i + 1) < k) {
				j++;
			} else if ((j - i + 1) == k) {
				result.add(list.peek());

				if (a[i] == list.peek()) {
					list.remove();
				}

				i++;
				j++;
			}

		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3); // 3, 3, 5, 5, 6, 6, 7

		solution(new int[] { 1, 3, 1, 2, 0, 5 }, 3);
	}

}
