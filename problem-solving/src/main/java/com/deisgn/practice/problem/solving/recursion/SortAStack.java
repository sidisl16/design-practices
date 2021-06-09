package com.deisgn.practice.problem.solving.recursion;

import java.util.Stack;

public class SortAStack {

	public static void solution(Stack<Integer> stack) {

		sort(stack);

		System.out.println(stack);
	}

	private static void sort(Stack<Integer> stack) {

		if (stack.isEmpty() || stack.size() <= 1) {
			return;
		}

		int pop = stack.pop();
		sort(stack);
		insert(stack, pop);

	}

	private static void insert(Stack<Integer> stack, Integer item) {

		if (stack.isEmpty() || stack.peek() <= item) {
			stack.push(item);
			return;
		}

		int val = stack.pop();
		insert(stack, item);
		stack.push(val);
		
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(5);
		stack.push(0);
		stack.push(2);

		solution(stack);

	}
}
