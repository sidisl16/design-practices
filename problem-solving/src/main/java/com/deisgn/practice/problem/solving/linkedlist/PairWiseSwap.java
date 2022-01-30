package com.deisgn.practice.problem.solving.linkedlist;

public class PairWiseSwap {

    public static void solution(LinkedList head) {
        if (head.next == null) {
            return;
        }

        LinkedList a = head;
        LinkedList b = head.next;
        LinkedList newHead = b;

        while (true) {
            LinkedList t = b.next;

            b.next = a;
            if (t == null || t.next == null) {
                a.next = t;
                break;
            }
            a.next = t.next;
            a = t;
            b = a.next;
        }

        head = newHead;

        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }

    }

    public static void main(String[] args) {
        solution(LinkedList.getDefault());
        System.out.println();
        solution(new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, null)))));
    }
}
