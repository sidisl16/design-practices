package com.deisgn.practice.problem.solving.strings;

public class PermutationString {

	public static void solution(String str) {

		int l = 0;
		int r = str.length() - 1;

		char[] a = str.toCharArray();

		permutation(a, l, r);

	}

	private static void permutation(char[] a, int l, int r) {

		if (l == r) {
			System.out.println(a);
			return;
		}

		for (int i = l; i <= r; i++) {
			swap(a, l, i);
			permutation(a, l + 1, r);
			swap(a, l, i);
		}
	}

	private static void swap(char[] a, int l, int i) {
		char temp = a[l];
		a[l] = a[i];
		a[i] = temp;
	}

	public static void main(String[] args) {
		String str = "ABC";
		solution(str);// ABC ACB BAC BCA CAB CBA
		str = "ABSG";
		solution(str);// ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA
		// GABS GASB GBAS
		// GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
	}

}
