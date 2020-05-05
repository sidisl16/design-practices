package com.deisgn.practice.problem.solving.strings;

public class ReverseWordsInString {

	public static void solution(String str) {
		String arr[] = str.split("\\.");
		StringBuilder builder = new StringBuilder();

		for (int i = arr.length - 1; i >= 0; i--) {

			builder.append(arr[i]);

			// Don't append . after last word
			if (i != 0) {
				builder.append(".");
			}

		}
		System.out.println(builder.toString());
	}

	/**
	 * 
	 * 
	 * Given a String of length S, reverse the whole string without reversing the
	 * individual words in it. Words are separated by dots
	 * 
	 */
	public static void main(String[] args) {

		String str = "i.like.this.program.very.much";
		solution(str);// much.very.program.this.like.i

		str = "pqr.mno";
		solution(str);// mno.pqr

	}

}
