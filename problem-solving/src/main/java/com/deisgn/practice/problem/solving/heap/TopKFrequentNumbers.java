package com.deisgn.practice.problem.solving.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentNumbers {

	private static void solution(int[] nums, int k) {

		PriorityQueue<Entry<Integer, Long>> minHeap = new PriorityQueue<>(
				(o1, o2) -> o1.getValue().compareTo(o2.getValue()));

		Map<Integer, Long> map = Arrays.stream(nums).boxed()
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

		map.entrySet().stream().forEach(e -> {
			minHeap.add(e);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		});

		minHeap.forEach(e -> System.out.println(e.getKey()));
	}

	public static void main(String[] args) {
		solution(new int[] { 5, 2, 1, 3, 2 }, 1);
	}

}
