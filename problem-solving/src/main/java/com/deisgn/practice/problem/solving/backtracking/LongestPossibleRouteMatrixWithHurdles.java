package com.deisgn.practice.problem.solving.backtracking;

public class LongestPossibleRouteMatrixWithHurdles {

	private static int max = 0;

	public static void getLongestPath(int[][] pathMatrix, int destX, int destY, int i, int j, int move, boolean[][] visisted) {

		if (i == destX && j == destY) {
			max = Math.max(max, move);
			return;
		}

		if (i < 0 || j < 0 || i >= pathMatrix.length || j >= pathMatrix[0].length || pathMatrix[i][j] == 0 || visisted[i][j]) {
			return;
		}
		
		visisted[i][j] = true;

		getLongestPath(pathMatrix, destX, destY, i, j + 1, move + 1, visisted);

		getLongestPath(pathMatrix, destX, destY, i + 1, j, move + 1, visisted);

		getLongestPath(pathMatrix, destX, destY, i - 1, j, move + 1, visisted);

		getLongestPath(pathMatrix, destX, destY, i, j - 1, move + 1, visisted);
		
		visisted[i][j] = false;
	}

	public static void main(String[] args) {

		int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		boolean[][] visited = new boolean[3][10];

		getLongestPath(mat, 1, 7, 0, 0, 0, visited);

		System.out.println(max);

	}

}
