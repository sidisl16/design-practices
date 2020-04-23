package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * The trick to this question is if y > x, then then x^y > y^x with some
 * exceptions.
 * 
 * Simply sort the array Y[], and for every element x in X[], find the index idx
 * of smallest number just greater than x in Y[]. All the elements after, this
 * index idx satisfy the above relation. So add (n - idx) to the ans.
 * 
 * Exceptions:
 * 
 * if x = 0, then count for this is 0.
 * 
 * if x = 1, then count is total no of 0s in Y[] only.
 * 
 * if x = 2, for y = 3, y = 4, the above property does not hold, and the count
 * should be decreased
 * 
 * if x = 3, for x = 2, the count need to be increased
 * 
 * Algorithm:
 * 
 * Array X and Y with size m and n respectively, x is an element in X and y is
 * an element in Y
 * 
 * sort(Y) //sort all elements y's in Y in ascending
 * 
 * for( element x in X)
 * 
 * if( x equals 0 ) continue; // Reason -> 0^y always 0, so x always < y
 * 
 * if( x equals 1 ) count no of 0's in Y and add it to the answer; // Reason -> 1^0 is always 1 and 1 > 0
 * 
 * find first y starting from 0 index in Y where x > y because if y > x then x^y > y^x, return index of y //for
 * better time complexity use binary search
 * 
 * add (index - length[Y] -1) to the answer
 * 
 * 
 * if( x equals 2 ) then x^3 and x^4 always < 3^x and 4^x respectively so subtract the count of (3's and 4's in Y) from answer   
 * 
 * if ( x equals 3) then x^2 always 2^x so add the count of (2's in Y) to the answer
 * 
 */
public class NoOfPairs {

	private static int binarySearch(int y[], int m, int key) {

		int high = m - 1;
		int low = 0;
		int index = high + 1;

		while (high >= low) {
			int mid = (high + low) / 2;
			if (y[mid] > key) {
				index = mid;
				high = mid - 1;
				break;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}

	public static void solution(int x[], int y[]) {
		int m = x.length;
		int n = y.length;
		int ans = 0;

		Arrays.sort(y);

		Map<Integer, Integer> frequency = new HashMap<>();

		for (int i = 0; i < y[n - 1]; i++) {
			frequency.put(i, 0);
		}

		for (int i = 0; i < n; i++) {

			if (frequency.containsKey(y[i])) {
				frequency.put(y[i], frequency.get(y[i]) + 1);
			} else {
				frequency.put(y[i], 1);
			}

		}

		for (int i = 0; i < m; i++) {

			// Handle exceptions
			if (x[i] == 0) {
				// Don't increase the count
				continue;
			}
			if (x[i] == 1) {
				// x=1 then count no of 0's in y
				ans += frequency.get(0);
				continue;
			}

			int index = binarySearch(y, n, x[i]);
			ans += (index - (n - 1)) + frequency.get(0) + frequency.get(1);

			if (x[i] == 2) {
				// if x== 2 then for y = 3 and y = 4 ans --
				ans -= frequency.get(3) - frequency.get(4);
			}

			if (x[i] == 3) {
				// x == 3 then count no of 2's
				ans += frequency.get(2);
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {

		int x[] = { 2, 1, 6 };
		int y[] = { 1, 5 };

		solution(x, y);// 3
	}
}