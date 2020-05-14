package com.deisgn.practice.problem.solving.strings;

import java.util.Arrays;

public class Anagram {

	public static void solution(String a, String b) {

		if (a.isEmpty() || b.isEmpty() || (a.length() != b.length())) {
			System.out.println(false);
			return;
		}

		solution1(a, b);
	}

	private static void solution1(String a, String b) {

		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();

		Arrays.sort(a1);
		Arrays.sort(b1);
		
		System.out.println(String.copyValueOf(a1).equals(String.copyValueOf(b1)));

	}

	public static void main(String[] args) {
		solution("act", "tac");// true
		solution("geeksforgeeks", "forgeeksgeeks");// true
		solution("allergy", "allergic");// false
	}
}
