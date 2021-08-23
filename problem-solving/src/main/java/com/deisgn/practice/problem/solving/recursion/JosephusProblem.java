package com.deisgn.practice.problem.solving.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JosephusProblem {

	public static void solution(int n, int k) {

		List<Integer> persons = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			persons.add(i + 1);
		}
		int i = 0;
		while (persons.size() > 1) {
			int index = (i + k - 1) % persons.size();
			persons.remove((i + k - 1) % persons.size());
			i = index;
		}
		System.out.println(persons);
	}

	public static void recusriveSolution(int k, List<Integer> persons, int index) {

		if (persons.size() == 1) {
			System.out.println(persons);
			return;
		}

		index = (index + k - 1) % persons.size();
		persons.remove(index);
		recusriveSolution(k, persons, index);
	}

	public static void main(String[] args) {
		solution(5, 3);
		List<Integer> persons = IntStream.range(1, 6).boxed().collect(Collectors.toList());
		recusriveSolution(3, new ArrayList<>(persons), 0);
	}
}
