package com.deisgn.practice.problem.solving.linkedlist;

public class IntersectionPointInYShapedLinkedList {

    public static void solution(LinkedList l1, LinkedList l2) {
        int l1len = 0, l2len = 0;

        LinkedList cur = l1;
        while (cur != null) {
            l1len++;
            cur = cur.next;
        }

        cur = l2;
        while (cur != null) {
            l2len++;
            cur = cur.next;
        }

        if (l1len > l2len) {
            while (l1len != l2len) {
                l1 = l1.next;
                l1len--;
            }
        } else {
            while (l1len != l2len) {
                l2 = l2.next;
                l2len--;
            }
        }

        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                System.out.println("Intersection point is " + l1.value);
                return;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        System.out.println("No intersection point found");
    }

    public static void main(String[] args) {
        LinkedList common = new LinkedList(15, new LinkedList(30, null));
        LinkedList l1 = new LinkedList(3, new LinkedList(6, new LinkedList(9, common)));
        LinkedList l2 = new LinkedList(10, common);

        solution(l1, l2);
    }
}
