package com.deisgn.practice.problem.solving.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

	private static void solution(String str) {
		int i = 0, j = 0;
		int max = 0;
		Map<Character, Integer> counter = new HashMap<>();

		while (j < str.length()) {

			if (counter.containsKey(str.charAt(j))) {
				counter.put(str.charAt(j), counter.get(str.charAt(j)) + 1);
			} else {
				counter.put(str.charAt(j), 1);
			}

			if (counter.size() == (j - i + 1)) {
				max = Math.max(max, j - i + 1);
			} else if (counter.size() < (j - i + 1)) {
				while (counter.size() < (j - i + 1)) {
					counter.put(str.charAt(i), counter.get(str.charAt(i)) - 1);
					if (counter.get(str.charAt(i)) == 0) {
						counter.remove(str.charAt(i));
					}
					i++;
				}
			}
			j++;
		}

		System.out.println(max);
	}

	public static void main(String[] args) {
		solution("pwwkew");
	}

}
