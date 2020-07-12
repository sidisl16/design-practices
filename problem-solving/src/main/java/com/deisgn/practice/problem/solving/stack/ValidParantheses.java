package com.deisgn.practice.problem.solving.stack;

import java.util.Stack;

public class ValidParantheses {

	public void solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char chr : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().equals(getBracket(chr))) {
				stack.pop();
			} else {
				stack.push(chr);
			}
		}
		System.out.println(stack.isEmpty());
	}

	private Character getBracket(char ch) {
		switch (ch) {
		case ']':
			return '[';
		case '}':
			return '{';
		case ')':
			return '(';	
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		new ValidParantheses().solution("()");
	}
}
