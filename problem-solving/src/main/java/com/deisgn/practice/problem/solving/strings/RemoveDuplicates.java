package com.deisgn.practice.problem.solving.strings;

public class RemoveDuplicates {

	public static void solution(String str) {

		int ascii[] = new int[256];
		String result = "";
		String strInLower = str.toLowerCase();

		for (int i = 0; i < strInLower.length(); i++) {

			if (ascii[(int) strInLower.charAt(i)] == 1) {
				continue;
			} else {
				ascii[(int) strInLower.charAt(i)] = 1;
				result += str.charAt(i);
			}
		}
		
		System.out.println(result);

	}

	public static void main(String[] args) {
		String str = "Dynamic-PrograMMing";

		solution(str);//Dynamic-Prog

		str = "GreEdy-Algorithm";

		solution(str);//Gredy-Aloithm
	}

}
