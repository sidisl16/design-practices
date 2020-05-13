package com.deisgn.practice.problem.solving.strings;

public class StringRotationBy2Place {

	public static void solution(String a, String b, int k) {

		// Clockwise rotation
		String a1 = a.substring(k, a.length()) + a.substring(0, k);

		// Anticlockwise rotation
		String a2 = a.substring(a.length() - k, a.length()) + a.substring(0, a.length()-k);

		System.out.println(a1.equals(b) || a2.equals(b));

	}

	public static void main(String[] args) {
		solution("amazon", "azonam", 2); // true

		solution("geeksforgeeks", "geeksgeeksfor", 2);// false
	}

}
