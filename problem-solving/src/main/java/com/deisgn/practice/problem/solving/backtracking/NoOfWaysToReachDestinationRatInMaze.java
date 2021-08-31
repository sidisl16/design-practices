package com.deisgn.practice.problem.solving.backtracking;

public class NoOfWaysToReachDestinationRatInMaze {


	public static int solution(int[][] maze, int x, int y) {

		if (x >= maze.length || y >= maze.length || x < 0 || y < 0 || maze[x][y] == -1) {
			return 0;
		}

		if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 0) {
			return 1;
		}

		return solution(maze, x, y + 1) + solution(maze, x + 1, y);
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(solution(maze, 0, 0));
	}

}
