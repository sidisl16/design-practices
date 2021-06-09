package com.deisgn.practice.problem.solving.binary.search;

import java.util.Arrays;

public class AllocateNumberOfPages {

	public static void solution(int nums[], int m) {

		int start = Arrays.stream(nums).max().getAsInt();
		int end = Arrays.stream(nums).sum();

		int res = -1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (isValid(nums, mid, m)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(res);
	}

	private static boolean isValid(int[] books, int mid, int k) {
		int noOfStudents = 1;
		int sum = 0;
		for (int i = 0; i < books.length; i++) {

			sum += books[i];

			if (sum > mid) {
				noOfStudents++;
				sum = books[i];
			}

			if (noOfStudents > k) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		solution(new int[] { 10, 20, 30, 40 }, 2);

		solution(new int[] { 7, 2, 5, 10, 8 }, 2);
	}

}
