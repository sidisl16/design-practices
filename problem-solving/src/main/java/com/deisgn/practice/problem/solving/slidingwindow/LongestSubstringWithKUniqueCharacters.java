package com.deisgn.practice.problem.solving.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

	public static void solution(String str, int k) {

		int i = 0, j = 0, max = 0;
		Map<Character, Integer> counter = new HashMap<>();

		while (j < str.length()) {

			if (counter.containsKey(str.charAt(j))) {
				counter.put(str.charAt(j), counter.get(str.charAt(j)) + 1);
			} else {
				counter.put(str.charAt(j), 1);
			}

			// Just for my understanding extra if condition is added, this can be optimized
			if (counter.size() < k) {
				j++;
			} else if (counter.size() == k) {
				System.out.println(i + " " + j);
				max = Math.max(max, (j - i + 1));
				j++;
			} else if (counter.size() > k) {
				while (counter.size() > k) {
					counter.put(str.charAt(i), counter.get(str.charAt(i)) - 1);
					if (counter.get(str.charAt(i)) == 0) {
						counter.remove(str.charAt(i));
					}
					i++;
				}
				j++;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		solution("aabacbebebe", 3);
	}

}
