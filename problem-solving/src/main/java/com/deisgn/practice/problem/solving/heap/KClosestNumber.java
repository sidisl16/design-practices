package com.deisgn.practice.problem.solving.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestNumber {

	private static void solution(int[] nums, int x, int k) {

		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.key.compareTo(o1.key);
			}
		});

		for (int n : nums) {

			maxHeap.add(new Pair(Math.abs((n - x)), n));
			
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		while(!maxHeap.isEmpty()) {
			System.out.println(maxHeap.poll().value);
		}
	}

	private static class Pair {

		private Integer key;
		private Integer value;

		public Pair(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
		
		
	}

	public static void main(String[] args) {
		solution(new int[] { 10, 2, 14, 4, 7, 6 }, 5, 3);
	}

}
