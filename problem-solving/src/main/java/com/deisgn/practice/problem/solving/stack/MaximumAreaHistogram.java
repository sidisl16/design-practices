package com.deisgn.practice.problem.solving.stack;

import java.util.Stack;

public class MaximumAreaHistogram {

	public void solution(int[] heights) {
		int n = heights.length;
		int[] nsl = new int[n];
		int[] nsr = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		nsl[0] = -1;

		for (int i = 1; i < n; i++) {

			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nsl[i] = -1;
			} else {
				nsl[i] = stack.peek();
			}

			stack.push(i);
		}

		stack.clear();
		nsr[n - 1] = n;
		stack.push(n - 1);

		for (int i = n - 2; i >= 0; i--) {

			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nsr[i] = n;
			} else {
				nsr[i] = stack.peek();
			}

			stack.push(i);
		}

		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int area = (nsr[i] - nsl[i] - 1) * heights[i];
			maxArea = Math.max(maxArea, area);
		}
		System.out.println(maxArea);
	}

	public static void main(String[] args) {
		// 6, 2, 5, 4, 5, 1, 6
		new MaximumAreaHistogram().solution(new int[] { 1,1});
	}

}
