package com.deisgn.practice.problem.solving.recursion;

import java.util.Stack;

public class DeleteMiddleElementInStack {

	public static void solution(Stack<Integer> stack) {

		int index = (stack.size() / 2) + 1;
		System.out.println(stack);
		delete(stack, index);
		System.out.println(stack);
	}

	private static void delete(Stack<Integer> stack, int index) {

		if (index == 1) {
			stack.pop();
			return;
		}

		int val = stack.pop();
		delete(stack, index - 1);
		stack.push(val);
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		stack.push(1);
		stack.push(5);
		stack.push(0);
		stack.push(2);
		stack.push(3);

		solution(stack);
	}

}
