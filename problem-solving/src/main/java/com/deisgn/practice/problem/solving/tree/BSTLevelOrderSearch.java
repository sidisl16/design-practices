package com.deisgn.practice.problem.solving.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTLevelOrderSearch {

	public static void solution(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			System.out.println(node.value);

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}
		}

	}

	public static void main(String[] args) {
		solution(TreeNode.getDefaultTree());
	}

}
