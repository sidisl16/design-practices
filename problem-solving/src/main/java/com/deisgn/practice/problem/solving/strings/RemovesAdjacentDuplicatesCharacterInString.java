package com.deisgn.practice.problem.solving.strings;

public class RemovesAdjacentDuplicatesCharacterInString {

	public static void solution(String str) {

		String result = itterativeSolution(str);

		System.out.println(result);

	}

	private static String itterativeSolution(String str) {
		int m = str.length();
		String res = "";

		if (str.isEmpty() || m == 1) {
			return str;
		}

		int i = 0;
		while (i < m) {

			if (i == m - 1 || str.charAt(i) != str.charAt(i + 1)) {

				if (!res.isEmpty() && str.charAt(i) == res.charAt(res.length() - 1)) {
					res = res.substring(0, res.length() - 1);
				} else {
					res += str.charAt(i);
				}
			}

			if (i + 1 < m && str.charAt(i) == str.charAt(i + 1)) {
				while (i + 1 < m && str.charAt(i) == str.charAt(i + 1)) {
					i++;
				}
			}

			i++;
		}

		return res;
	}

	public static void main(String[] args) {
		String str = "azxxxzy";// ay
		solution(str);

		str = "acaaabbbacdddd";// acac
		solution(str);

		str = "caaabbbaac";// empty
		solution(str);

		System.out.println("************end**************");
	}
}
