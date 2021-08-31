package com.deisgn.practice.problem.solving.backtracking;

public class RatInAMaze {

	public static boolean solution(int[][] maze, int[][] sol, int x, int y) {

		if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}

		if (maze[x][y] == 0) {
			return false;
		}

		sol[x][y] = 1;

		if (solution(maze, sol, x, y + 1)) {
			return true;
		}

		if (solution(maze, sol, x + 1, y)) {
			return true;
		}

		sol[x][y] = 0;

		return false;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] sol = new int[n][n];
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		solution(maze, sol, 0, 0);

		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}

}
