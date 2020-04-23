package com.deisgn.practice.problem.solving.arrays;

public class NewYearChaosProblem {

	
	
	
	/**
	 * 
	 * Case 1. if number is not in its position, if (a[i] != i+1)
	 * 
	 * Case 2. a). If it has bribed 1 q[i-1] = i+1, swapcount++ , swap(q, i-1, i)
	 * 		   b). If it has bribed 2 q[i-2] = i+1, swapcount+2 , swap(q, i-2, i-1), swap(q, i-1, i)
	 * Case 3 else "Too chaotic" 
	 * 
	 */
    static void minimumBribes(int[] q) {
    	int swapcount = 0;
    	for(int i=q.length-1; i>=0; i--) {
    		if(q[i] != i+1) {
    			if((i-1 >= 0) && (q[i-1] == (i+1))) {
    				swapcount++;
    				swap(q, i, i-1);
    			} else if((i-2 >= 0) && (q[i-2] == (i+1))) {
    				swapcount+=2;
    				swap(q, i-2, i-1);
    				swap(q, i-1, i);
    			} else {
    				System.out.println("Too chaotic");
    				return;
    			}
    		}
    	}
    	System.out.println(swapcount);
    }

    private static void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }

	public static void main(String[] args) {
		int q[] = {1,2,5,4,3};
		minimumBribes(q);//3
	}
}

