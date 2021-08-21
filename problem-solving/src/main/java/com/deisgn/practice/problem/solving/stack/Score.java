package com.deisgn.practice.problem.solving.stack;

import java.util.Stack;

/**
 * 
 * 5 - add to the score board - [5]
 * 2 - add to the score board - [5, 2]
 * C - Cancel previous score, it is granted previous score will be available  - [5]
 * D - Multiply by 2 to previous score 2*5=10, it is granted previous score will be available [5, 10]
 * + - Add 5 to the previous score 10+5 = 15 [5, 10, 15]
 * 
 * result = 5+10+15
 */
public class Score {
	
	public static int calculate(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		for(String s: ops) {
			if(s.matches("[0-9]*")) {
				stack.push(Integer.parseInt(s));
			} else {
				switch (s) {
				case "C":
					stack.pop();
					break;
				case "D":
					stack.push(stack.peek() * 2);
					break;	
				case "+":
					stack.push(stack.peek() + 5);
					break;
				default:
					break;
				}
			}
		}
		while(!stack.isEmpty()) {
			result+=stack.pop();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(calculate("5 2 C D +".split(" ")) == 30);
	}

}
