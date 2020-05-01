package com.deisgn.practice.problem.solving.arrays;

public class StockBuyAndSell {

	public static void solution(int a[]) {

		int i = 0;
		int j = 0;
		int m = a.length;

		while (j < m) {

			if (j < m - 1 && a[j] < a[j + 1]) {
				j++;
				continue;
			}
			int profit = a[j] - a[i];

			if (profit > 0) {
				// We can write logic here for max profit buy and sell day
				System.out.print("(" + i + "," + j + ") ");
			}
			i = ++j;
		}

	}

	public static void main(String[] args) {
		int a[] = { 100, 180, 260, 310, 40, 535, 695 };

		solution(a);// (0 3) (4 6)

		int a1[] = { 23, 13, 25, 29, 33, 19, 34, 45, 65, 67 };

		solution(a1);// (1 4) (5 9)
	}

}
