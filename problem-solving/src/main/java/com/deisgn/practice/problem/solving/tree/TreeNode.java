package com.deisgn.practice.problem.solving.tree;

public class TreeNode {

	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value, TreeNode left, TreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public static TreeNode getDefaultTree() {
		return new TreeNode(1, new TreeNode(2, null, null),
				new TreeNode(3, new TreeNode(4, null, null), new TreeNode(5, null, null)));
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
