package com.deisgn.practice.problem.solving.tree;

public class FlattenBTintoLinkedList {

	static class LinkedList {

		int value;
		LinkedList next;

		public LinkedList(int value, LinkedList next) {
			super();
			this.value = value;
			this.next = next;
		}
	}

	public static void solution(TreeNode head, TreeNode result) {

		if (head == null) {
			return;
		}
		
		
		result.right = head;
		
		solution(head.left, result.right);

		solution(head.right, result.right);
	}

	public static void main(String[] args) {
		TreeNode result = new TreeNode(0, null, null);
		solution(TreeNode.getDefaultTree(), result);
		
		
	}

}
