package com.deisgn.practice.problem.solving.stack;

import java.util.Stack;

public class StockSpanProblem {

	public void solution(int[] a) {
		Stack<Integer> stack = new Stack<>();
		int[] indices = new int[a.length];
		indices[0] = -1;
		stack.push(0);

		for (int i = 1; i < a.length; i++) {

			while (!stack.isEmpty() && a[i] > a[stack.peek()]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				indices[i] = -1;
			} else {
				indices[i] = stack.peek();
			}

			stack.push(i);
		}

		for (int i = 0; i < indices.length; i++) {
			System.out.println(i - indices[i]);
		}

	}

	public static void main(String[] args) {
		new StockSpanProblem().solution(new int[] { 100, 80, 60, 70, 60, 75, 85 }); // 1,1,1,2,1,4,6
	}
}
