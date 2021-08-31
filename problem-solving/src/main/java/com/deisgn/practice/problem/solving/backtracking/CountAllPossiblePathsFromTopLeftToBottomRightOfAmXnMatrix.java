package com.deisgn.practice.problem.solving.backtracking;

public class CountAllPossiblePathsFromTopLeftToBottomRightOfAmXnMatrix {

	public static int solution(int[][] matrix, int x, int y) {

		if (x >= matrix.length || y >= matrix.length || x < 0 || y < 0) {
			return 0;
		}

		if (x == matrix.length - 1 && y == matrix.length - 1) {
			return 1;
		}

		return solution(matrix, x, y + 1) + solution(matrix, x + 1, y);
	}

	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		System.out.println(solution(matrix, 0, 0));
	}
}