package com.deisgn.practice.problem.solving.recursion;

import java.util.Stack;

public class ReverseStack {
	
	public static void solution(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		
		int val = stack.pop();
		solution(stack);
		
	}
	
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(1);
		stack.push(5);
		stack.push(0);
		stack.push(2);
		stack.push(3);

		System.out.println(stack);
		solution(stack);
		System.out.println(stack);
	}

}
