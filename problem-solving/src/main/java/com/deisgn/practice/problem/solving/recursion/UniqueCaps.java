package com.deisgn.practice.problem.solving.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UniqueCaps {

	private static List<List<Integer>> out = new ArrayList<>();
	private static Map<Integer, LinkedList<Integer>> map = new HashMap<>();

	public static void countNoOfWays(int n, Set<Integer> op, int choice) {

		if (choice != -1)
			op.add(choice);

		if (n == 0) {
			if (op.size() == map.size()) {
				out.add(new ArrayList<>(op));
			}
			return;
		}

		for (int i = 0; i < map.get(n).size(); i++) {
			countNoOfWays(n - 1, op, map.get(n).get(i));
			if (!op.isEmpty() && (map.size() - n) + 1 == op.size())
				op.remove(op.toArray()[op.size() - 1]);
		}
	}

	public static void main(String[] args) {
		map.put(1, new LinkedList<>(List.of(5, 100, 1)));
		map.put(2, new LinkedList<>(List.of(2)));
		map.put(3, new LinkedList<>(List.of(5, 100)));
		int n = map.size();
		Set<Integer> op = new LinkedHashSet<>();
		countNoOfWays(n, op, -1);
		System.out.println(out);
	}

}
