package Leetcode;

import java.util.List;

public class RotateRight {
    public static void main(String[] args) {
        RotateRight test = new RotateRight();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        a2.next = null;
        ListNode re = test.rotateRight(a1, 2);
        System.out.println();
    }
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }

        int len = 0;
        for (ListNode a = head; a != null; a = a.next) {
            len++;
        }

        n = n % len;
        if (n == 0 || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        for (int i = n; i > 0; i--) {
            right = right.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        ListNode newHead = left.next;
        right.next = head;
        left.next = null;
        return newHead;
    }
}
