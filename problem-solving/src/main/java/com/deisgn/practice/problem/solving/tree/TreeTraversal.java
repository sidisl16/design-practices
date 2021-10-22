package com.deisgn.practice.problem.solving.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	public static void preorder(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.value);

			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}

	}

	public static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;

		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();

			System.out.println(node.value);

			TreeNode rnode = node.right;
			while (rnode != null) {
				stack.push(rnode);
				rnode = rnode.left;
			}
		}

	}

	public static void levelorder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {

			Queue<TreeNode> newQueue = new LinkedList<>();

			List<Integer> list = new ArrayList<>();

			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				list.add(node.value);
				if (node.left != null) {
					newQueue.add(node.left);
				}
				if (node.right != null) {
					newQueue.add(node.right);
				}
			}
			result.add(list);

			queue = newQueue;
		}

		System.out.println(result);
	}

	public static void postorder(TreeNode root) {
		
	}

	public static void main(String[] args) {
		levelorder(TreeNode.getDefaultTree());
	}

}
