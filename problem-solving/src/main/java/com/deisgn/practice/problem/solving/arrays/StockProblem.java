package com.deisgn.practice.problem.solving.arrays;

public class StockProblem {

	public static void main(String[] args) {
		// [500, 100, 600, 2, 300, 700, 1000, 1]

		int[] arr = new int[] { 500, 100, 600, 2, 300, 700, 1000, 1 };

		int min = 0;
		Result maxResult = new Result(0, 0, Integer.MIN_VALUE);

		for (int i = 1; i < arr.length; i++) {
			Result currentDay = new Result(i + 1, min + 1, arr[i] - arr[min]);

			if (maxResult.profit < currentDay.profit) {
				maxResult = currentDay;
			}

			if (arr[min] > arr[i]) {
				min = i;
			}
		}

		System.out.println(maxResult);

	}
}

class Result {
	int sellingDay;
	int buyingDay;
	int profit;

	public Result(int sellingDay, int buyingDay, int profit) {
		super();
		this.sellingDay = sellingDay;
		this.buyingDay = buyingDay;
		this.profit = profit;
	}

	@Override
	public String toString() {
		return "Result [sellingDay=" + sellingDay + ", buyingDay=" + buyingDay + ", profit=" + profit + "]";
	}

}
