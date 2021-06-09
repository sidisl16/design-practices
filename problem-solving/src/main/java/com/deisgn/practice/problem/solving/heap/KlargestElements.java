package com.deisgn.practice.problem.solving.heap;

import java.util.PriorityQueue;

public class KlargestElements {


	public static void solution(int[] nums, int k) {

		// Min heap
		PriorityQueue<Integer> minheap = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			
			minheap.add(nums[i]);
			
			if(minheap.size() > k) {
				minheap.poll();
			}
		}
		
		while(!minheap.isEmpty()) {
			System.out.println(minheap.poll());
		}
	}

	public static void main(String[] args) {
		solution(new int[] { 7, 10, 4, 3, 20, 15 }, 3);
	}

}
