package com.deisgn.practice.problem.solving.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	private static void solution(int[][] nums, int k) {

		PriorityQueue<Pair> maxheap = new PriorityQueue<>((o1, o2) -> o2.distance.compareTo(o1.distance));

		for (int i = 0; i < nums.length; i++) {
			double distance = Math.sqrt(Math.pow(nums[i][0], 2) + Math.pow(nums[i][1], 2));
			maxheap.add(new Pair(distance, nums[i]));
			
			if(maxheap.size() > k) {
				maxheap.poll();
			}
		}

		maxheap.forEach(e -> System.out.println(Arrays.toString(e.point)));
	}

	private static class Pair {

		private Double distance;
		private int[] point;

		public Pair(Double distance, int[] point) {
			this.distance = distance;
			this.point = point;
		}
	}

	public static void main(String[] args) {
		solution(new int[][] { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } }, 2);
	}

}
