package com.deisgn.practice.problem.solving.linkedlist;

public class MergeSortedTwoLinkedList {

    public static void solution(LinkedList l1, LinkedList l2) {

        LinkedList resHead = null;
        LinkedList res = new LinkedList(0, null);

        while(l1 != null && l2 != null) {

            if(l1.value < l2.value) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }

            res = res.next;
            res.next = null;

            if(resHead == null) {
                resHead = res;
            }
        }

        if(l1!= null) {
            res.next = l1;
        } else {
            res.next = l2;
        }

        while(resHead != null) {
            System.out.println(resHead.value);
            resHead = resHead.next;
        }
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(5, new LinkedList(10, new LinkedList(15, new LinkedList(40, null))));
        LinkedList l2 = new LinkedList(2, new LinkedList(3, new LinkedList(20, null)));

        solution(l1, l2);
    }
}