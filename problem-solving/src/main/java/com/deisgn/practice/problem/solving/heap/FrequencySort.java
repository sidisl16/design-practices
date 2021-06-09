package com.deisgn.practice.problem.solving.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class FrequencySort {

	public static void solution(int[] nums) {

		PriorityQueue<Entry<Integer, Long>> maxHeap = new PriorityQueue<>(
				(o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		Map<Integer, Long> map = Arrays.stream(nums).boxed()
				.collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

		map.entrySet().forEach(e -> maxHeap.add(e));

		maxHeap.forEach(e -> {
			LongStream.range(0l, e.getValue()).forEach(k -> System.out.println(e.getKey()));
		});
	}

	public static void main(String[] args) {
		solution(new int[] { 1, 1, 1, 3, 2, 2, 4, 2, 2, 2 });
	}
}
