package com.deisgn.practice.problem.solving.stack;

import java.util.Stack;

public class SimplyfyPath {

	public void solution(String path) {

		Stack<String> stack = new Stack<>();

		for (String s : path.split("/")) {
			if (s.isEmpty()) {
				continue;
			}
			if (s.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!s.equals(".") && !s.equals("..")) {
				stack.push(s);
			}
		}

		String result = "";

		if (stack.isEmpty()) {
			result = "/";
		} else {
			while (!stack.isEmpty()) {
				result = "/" + stack.pop() + result;
			}
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		new SimplyfyPath().solution("/a//b////c/d//././/..");
	}

}
