package com.deisgn.practice.problem.solving.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class AnagramOccurances {

	private static void solution(String s1, String s2) {
		Map<Character, Integer> counter = new HashMap<>();
		int l = 0;
		int anagramCount = 0;

		// Map to keep track of count of each character in s2
		while (l < s2.length()) {
			if (counter.containsKey(s2.charAt(l))) {
				counter.put(s2.charAt(l), counter.get(s2.charAt(l)) + 1);
			} else {
				counter.put(s2.charAt(l), 1);
			}
			l++;
		}

		// Count variable is 0 if all character count in counter map is 0
		int count = counter.size();

		int i = 0, j = 0, k = s2.length();
		while (j < s1.length()) {

			if (counter.containsKey(s1.charAt(j))) {
				counter.put(s1.charAt(j), counter.get(s1.charAt(j)) - 1);

				if (counter.get(s1.charAt(j)) == 0) {
					count--;
				}
			}

			if ((j - i + 1) < k) {
				j++;
			} else if ((j - i + 1) == k) {

				// if count is 0 means we found the anagram
				if (count == 0) {
					anagramCount++;
				}
				// slide window and add the count of the first character in the counter map
				if (counter.containsKey(s1.charAt(i))) {
					counter.put(s1.charAt(i), counter.get(s1.charAt(i)) + 1);
					// Undo the counter decrement after sliding the window
					if (counter.get(s1.charAt(i)) == 1)
						count++;
				}

				i++;
				j++;
			}

		}

		System.out.println(anagramCount);
	}

	public static void main(String[] args) {
		solution("forxxorfxdofr", "for"); // 3

		solution("aabaabaa", "aaba"); // 4
	}

}
