package com.deisgn.practice.problem.solving.interview.leetcode;

public class LongestCommonPrefix {

	public static String solution(String[] strs) {

		String res = strs[0];

		for (int i = 1; i < strs.length; i++) {
			res = getCommonString(res, strs[i]);
		}
		return res;
	}

	private static String getCommonString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		int i = 0;
		for (; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			}
		}
		return s1.substring(0, i);
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "dog", "racecar", "car" }));
	}

}
