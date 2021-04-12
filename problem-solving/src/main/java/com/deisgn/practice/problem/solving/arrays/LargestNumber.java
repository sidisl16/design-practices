package com.deisgn.practice.problem.solving.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void solution(int nums[]) {
		String[] numStr = new String[nums.length];
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < nums.length; i++) {
			numStr[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(numStr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String order1 = o1 + o2;
				String order2 = o2 + o1;
				return order2.compareTo(order1);
			}

		});
		
        if (numStr[0].equals("0")) {
        	System.out.println(0);
            return;
        }

		for (String str : numStr) {
			buffer.append(str);
		}

		System.out.println(buffer.toString());
	}

	public static void main(String[] args) {
		solution(new int[] { 3, 30, 34, 5, 9 });
		solution(new int[] { 0, 0 });

	}

}
