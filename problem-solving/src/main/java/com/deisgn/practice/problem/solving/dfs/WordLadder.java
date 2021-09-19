package com.deisgn.practice.problem.solving.dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	static class WordNode {

		String word;
		int steps;

		public WordNode(String word, int steps) {
			super();
			this.word = word;
			this.steps = steps;
		}
	}

	public static int solution(String start, String end, Set<String> dictionary) {
		Queue<WordNode> queue = new LinkedList<>();

		queue.add(new WordNode(start, 1));
		dictionary.add(end);

		while (!queue.isEmpty()) {

			WordNode wordNode = queue.poll();

			if (wordNode.word.equals(end)) {
				return wordNode.steps;
			}

			char[] a = wordNode.word.toCharArray();
			for (int i = 0; i < a.length; i++) {

				for (char ch = 'a'; ch <= 'z'; ch++) {

					char temp = a[i];

					if (a[i] != ch) {
						a[i] = ch;
					}

					String s = new String(a);

					if (dictionary.contains(s)) {
						queue.add(new WordNode(s, wordNode.steps + 1));
						dictionary.remove(s);
					}
					a[i] = temp;
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int steps = solution("hit", "cog", new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log")));
		System.out.println(steps);
	}

}
