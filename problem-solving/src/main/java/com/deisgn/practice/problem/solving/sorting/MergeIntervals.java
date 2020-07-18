package com.deisgn.practice.problem.solving.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

	public int[][] solution(int[][] intervals) {

		if (intervals == null || intervals.length == 0) {
			return new int[0][0];
		}

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		Stack<int[]> stack = new Stack<>();
		stack.push(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			int[] top = stack.peek();
			if (top[1] >= intervals[i][0]) {
				stack.pop();
				stack.push(new int[] { Math.min(intervals[i][0], top[0]), Math.max(intervals[i][1], top[1]) });
			} else {
				stack.push(new int[] { intervals[i][0], intervals[i][1] });
			}
		}
		int[][] merged = new int[stack.size()][2];
		int i = stack.size() - 1;
		while (!stack.isEmpty()) {
			int[] top = stack.pop();
			merged[i][0] = top[0];
			merged[i][1] = top[1];
			System.out.println(merged[i][0] + " " + merged[i][1]);
			i--;
		}
		return merged;
	}

	public static void main(String[] args) {
		new MergeIntervals().solution(new int[][] { { 0, 0 }, { 1, 4 } });
	}
}
