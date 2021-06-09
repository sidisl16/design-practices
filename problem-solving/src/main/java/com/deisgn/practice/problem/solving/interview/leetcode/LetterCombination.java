package com.deisgn.practice.problem.solving.interview.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

	private static Map<Character, String> map;

	static {
		map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}

	public static List<String> solution(String digits) {

		List<String> res = new ArrayList<>();

		if (digits == null || digits.isEmpty()) {
			return res;
		}

		getCombination(res, 0, "", digits);
		return res;
	}

	private static void getCombination(List<String> res, int index, String current, String digits) {

		if (current.length() == digits.length()) {
			res.add(current);
			return;
		}

		String letters = map.get(digits.charAt(index));
		for (int i = 0; i < letters.length(); i++) {
			getCombination(res, index + 1, current + letters.charAt(i), digits);
		}

	}

	public static void main(String[] args) {
		System.out.println(solution("23"));
	}

}
