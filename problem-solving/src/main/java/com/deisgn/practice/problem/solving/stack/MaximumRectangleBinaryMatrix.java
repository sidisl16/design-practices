package com.deisgn.practice.problem.solving.stack;

import java.util.Stack;

public class MaximumRectangleBinaryMatrix {

	public void solution(char[][] matrix) {
		int[][] heights = new int[matrix.length][];
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			heights[i] = new int[matrix[i].length];
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0) {
					heights[i][j] = Character.getNumericValue(matrix[i][j]);
					continue;
				}

				if (matrix[i][j] == '1') {
					heights[i][j] = heights[i-1][j] + Character.getNumericValue(matrix[i][j]);
				} else {
					heights[i][j] = 0;
				}
			}
			maxArea = Math.max(maxArea, mha(heights[i]));
		}
		
		System.out.println(maxArea);
	}

	private int mha(int[] heights) {

		int n = heights.length;
		int[] nsl = new int[n];
		int[] nsr = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		nsl[0] = -1;

		for (int i = 1; i < n; i++) {

			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
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

		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println(Character.getNumericValue('1'));
		new MaximumRectangleBinaryMatrix().solution(new char[][] { { '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } });
	}
}
