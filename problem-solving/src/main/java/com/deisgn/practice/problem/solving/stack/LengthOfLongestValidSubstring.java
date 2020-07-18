package com.deisgn.practice.problem.solving.stack;

import java.util.Stack;

public class LengthOfLongestValidSubstring {

	public void solution(String str) {
		if(str.isEmpty()) {
			
		}
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (char ch : str.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			} else if (!stack.isEmpty()) {
				stack.pop();
				count = count + 2;
			}
		}
		System.out.println(str.length()-count);
	}

	public static void main(String[] args) {
		new LengthOfLongestValidSubstring().solution("()(()))))");
	}

}
