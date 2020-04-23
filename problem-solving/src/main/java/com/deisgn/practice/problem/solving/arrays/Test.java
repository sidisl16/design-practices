package com.deisgn.practice.problem.solving.arrays;

public class Test {
	private static int BUILD_MASK = 0x000000FF;
	private static int MINOR_MASK = 0x0000FF00;
	private static int MAJOR_MASK = 0xFFFF0000;
	private static int MINOR_SHFT = 8;
	private static int MAJOR_SHFT = 16;
	private static int integerRepresentation = 1235678;
	
	
	public static void main(String[] args) {
		int major = (integerRepresentation & MAJOR_MASK) >> MAJOR_SHFT;
		int minor = (integerRepresentation & MINOR_MASK) >> MINOR_SHFT;
		int build = integerRepresentation & BUILD_MASK;
		System.out.println(major + "." + minor + "." + build);
	}
	
}
