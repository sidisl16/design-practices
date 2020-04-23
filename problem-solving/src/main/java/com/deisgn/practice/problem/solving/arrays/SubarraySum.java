package com.deisgn.practice.problem.solving.arrays;

public class SubarraySum {

	public static void solution(int arr[], int sum) {
		int i = 0;
		int j = 0;
		int res = 0;

		while (j < arr.length) {
			
			if (res == sum) {
				break;
			}

			if (res < sum) {
				res = res + arr[j];
				j++;
			}

			if (res > sum) {
				res = res - arr[i];
				i++;
			}
			
		}

		if (res == sum) {
			System.out.println((++i) + " " + j);
		} else {
			System.out.println(-1);
		}

	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 7, 5 };
		solution(arr, 12);// 12

		int arr1[] = { 1, 2, 3 };
		solution(arr1, 3);// 3

		int arr2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		solution(arr2, 15);//15

		int arr3[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		solution(arr3, 150);//-1

	}
}
