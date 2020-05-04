package com.deisgn.practice.problem.solving.arrays;

public class LastIndexOfOne {

	public static void solution(String str) {

		char[] chr = str.toCharArray();

		int i = chr.length - 1;

		while (i >= 0 && chr[i] != '1') {
			i--;
		}

		System.out.println(str.length() + " " + i);

	}

	public static void main(String[] args) {
		String str = "0101111000100";
		solution(str);

		str = "00000000";
		solution(str);

		str = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
		solution(str);
	}

}
