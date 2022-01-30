package com.deisgn.practice.problem.solving.linkedlist;

public class RemoveLoopFromLinkedList {

    public static void solution(LinkedList head) {

        if (head == null || head.next == null) {
            return;
        }

        LinkedList s = head;
        LinkedList f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                s = head;
                while (s.next != f.next) {
                    s = s.next;
                    f = f.next;
                }
                f.next = null;
                break;
            }
        }

        s = head;
        while (s != null) {
            System.out.println(s.value);
            s = s.next;
        }
    }

    public static void main(String[] args) {
        LinkedList loopElement = new LinkedList(6, null);
        LinkedList loop = new LinkedList(3, new LinkedList(4, new LinkedList(5, loopElement)));
        loopElement.next = loop;

        LinkedList head = new LinkedList(1, new LinkedList(2, loop));

        solution(head);
    }
}
