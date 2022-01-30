package com.deisgn.practice.problem.solving.linkedlist;

public class LinkedList {

    Integer value;
    LinkedList next;

    public LinkedList(Integer value, LinkedList next) {
        this.value = value;
        this.next = next;
    }

    public static LinkedList getDefault() {
        return new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5, null)))));
    }

    public static void print(LinkedList head) {
        LinkedList c = head;
        while (c != null) {
            System.out.println(c.value);
            c = c.next;
        }
    }
}