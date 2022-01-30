package com.deisgn.practice.problem.solving.linkedlist;

public class ReverseLinkedListInGroups {

    public static LinkedList solution(LinkedList head, int k) {
        LinkedList a = null;
        LinkedList b = head;
        LinkedList c = head;
        int count = 0;

        while (count < k && b != null) {
            c = c.next;
            b.next = a;
            a = b;
            b = c;
            count++;
        }

        if (c != null) {
            head.next = solution(c, k);
        }

        return a;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(1, new LinkedList(2, new LinkedList(2, new LinkedList(4, new LinkedList(5, new LinkedList(6, new LinkedList(7, new LinkedList(8, null))))))));

        LinkedList.print(solution(l1, 4));
    }
}
