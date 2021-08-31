package com.deisgn.practice.problem.solving.backtracking;

public class NQueens {

	public static void solution(int[][] board, int n) {

		if (n > board.length) {
			System.out.println("-----------------------");
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}

		for (int i = 0; i < board.length; i++) {

			if (isSafeMove(board, n - 1, i)) {

				board[n - 1][i] = n;

				solution(board, n + 1);
				// Backtrack
				board[n - 1][i] = 0;
			}
		}
	}

	private static boolean isSafeMove(int[][] board, int row, int col) {

		for (int i = 0; i < row; i++) {
			if (board[i][col] > 0) {
				return false;
			}
		}
		int i = row - 1, j = col + 1;
		
		// Check left upper diagonal
		while (i >= 0 && i < board.length && j >= 0 && j < board.length) {
			
			if (board[i][j] > 0) {
				return false;
			}
			
			i--;
			j++;
		}
		
		i = row - 1; j = col -1;
		
		// Check right upper diagonal
		while (i >= 0 && i < board.length && j >= 0 && j < board.length) {
			
			if (board[i][j] > 0) {
				return false;
			}
			
			i--;
			j--;
		}

		return true;

	}

	public static void main(String[] args) {
		int n = 4;
		int[][] board = new int[n][n];
		solution(board, 1);

	}

}
