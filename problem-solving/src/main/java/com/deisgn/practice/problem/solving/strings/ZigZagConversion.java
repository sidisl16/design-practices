package com.deisgn.practice.problem.solving.strings;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

	public static void convert(String s, int numRows) {
		Map<Integer, StringBuffer> map = new HashMap<>();

		int pos = 1;
		boolean dir = true;

		for (char ch : s.toCharArray()) {
			
			if(map.containsKey(pos)) {
				map.put(pos, map.get(pos).append(ch));
			} else {
				map.put(pos, (new StringBuffer()).append(ch));
			}
			
			if (pos == numRows) {
				dir = false;
			}
			
			if (pos == 1) {
				dir = true;
			}
			
			if(dir) {
				pos++;
			} else {
				pos--;
			}
			
		}
		
		StringBuffer result = new StringBuffer();
		pos = 1;
		while(pos <= map.size()) {
			result.append(map.get(pos).toString());
			pos++;
		}
		
		
		System.out.println(result.toString());
	}

	public static void main(String[] args) {
		convert("PAYPALISHIRING", 3);//PAHNAPLSIIGYIR
		convert("PAYPALISHIRING", 4);
		convert("AB", 1);
	}

}
