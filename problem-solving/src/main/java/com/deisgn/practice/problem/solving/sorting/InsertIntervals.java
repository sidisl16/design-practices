package com.deisgn.practice.problem.solving.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class InsertIntervals {

	public int[][] insert(int[][] intervals, int[] newInterval) {

		if (intervals == null || intervals.length == 0) {
			return new int[][] { { newInterval[0], newInterval[1] } };
		}

		List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
		list.add(newInterval);

		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		Stack<int[]> stack = new Stack<>();
		stack.push(list.get(0));

		for (int i = 1; i < list.size(); i++) {
			int[] top = stack.peek();
			if (top[1] >= list.get(i)[0]) {
				stack.pop();
				stack.push(new int[] { Math.min(list.get(i)[0], top[0]), Math.max(list.get(i)[1], top[1]) });
			} else {
				stack.push(new int[] { list.get(i)[0], list.get(i)[1] });
			}
		}

		int[][] merged = new int[stack.size()][2];
		stack.toArray(merged);

		return merged;
	}

	public static void main(String[] args) {
		int[][] res = new InsertIntervals().insert(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }, { 9, 10 },
				{ 11, 12 }, { 13, 14 }, { 19997, 19998 }, { 19999, 20000 } }, new int[] { 0, 20001 });
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}
}
