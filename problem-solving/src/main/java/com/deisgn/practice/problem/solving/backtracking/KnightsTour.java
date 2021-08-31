package com.deisgn.practice.problem.solving.backtracking;

public class KnightsTour {

	private static int r[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int c[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static boolean solution(int[][] chess, int move, int x, int y) {

		if (move == (chess.length * chess.length) + 1) {
			return true;
		}

		for (int i = 0; i < chess.length; i++) {

			int next_x = x + r[i];
			int next_y = y + c[i];

			if (next_x >= 0 && next_y >= 0 && next_x < chess.length && next_y < chess.length
					&& chess[next_x][next_y] == 0) {
				
				chess[next_x][next_y] = move;
				
				if (solution(chess, move + 1, next_x, next_y))
					return true;
				// Backtrack
				chess[next_x][next_y] = 0;
			}
		}

		return false;
	}

	private static void printChess(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 8;
		int[][] chess = new int[n][n];
		chess[0][0] = 1;
		System.out.println(solution(chess, 2, 0, 0));
		printChess(chess);

	}

}
