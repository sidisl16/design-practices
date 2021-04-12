package com.deisgn.practice.problem.solving.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMatrixDiagonally {

	public static void solution(int nums[][]) {

		List<Integer> list = new ArrayList<>();
		int m = nums.length;
		int n = nums[0].length;
		int[][] result = new int[m][n];

		int r = 1;
		int c = 0;

		while (r < m || c < n) {

			if (c < n) {

				int i = 0;
				int j = c;

				while (j < n && i < m) {
					list.add(nums[i++][j++]);
				}

				Collections.sort(list);

				i = 0;
				j = c;
				int k = 0;

				while (j < n && i < m) {
					result[i++][j++] = list.get(k++);
				}
				list.clear();
				c++;
			} else if (r < m) {

				int i = r;
				int j = 0;

				while (j < n && i < m) {
					list.add(nums[i++][j++]);
				}

				Collections.sort(list);
				
				i = r;
				j = 0;
				int k = 0;
				while (j < n && i < m) {
					result[i++][j++] = list.get(k++);
				}
				list.clear();
				r++;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		solution(new int[][] { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } });
	}
}
