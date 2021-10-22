package com.deisgn.practice.problem.solving.recursion;

public class RecursivelyRemoveAllAdjacentDuplicates {

	public static void solution(String s) {

		if (s.isEmpty()) {
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		s = "~" + s + "~";
		boolean isDuplicateFound = false;
		for (int i = 1; i < s.length() - 1; i++) {
			if ((s.charAt(i) != s.charAt(i - 1)) && (s.charAt(i) != s.charAt(i + 1))) {
				builder.append(s.charAt(i));
			} else {
				isDuplicateFound = true;
			}
		}
		if (isDuplicateFound)
			solution(builder.toString());
		else 
			System.out.println(builder.toString());
	}

	public static void main(String[] args) {
		solution("acaaabbbacdddd");
	}

}
