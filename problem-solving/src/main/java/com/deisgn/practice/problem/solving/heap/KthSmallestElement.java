package com.deisgn.practice.problem.solving.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

	public static void solution(int[] nums, int k) {

		// Max heap
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < nums.length; i++) {
			
			maxheap.add(nums[i]);
			
			if(maxheap.size() > k) {
				maxheap.poll();
			}
		}
		
		// Kth smallest element
		System.out.println(maxheap.peek());
	}

	public static void main(String[] args) {
		solution(new int[] { 7, 10, 4, 3, 20, 15 }, 3);
	}
}
