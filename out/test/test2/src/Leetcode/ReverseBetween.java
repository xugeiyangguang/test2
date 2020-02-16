package Leetcode;

public class ReverseBetween {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;
        ListNode re = new ReverseBetween().reverseBetween(a1, 2, 5);
        System.out.println();
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode curNode = newHead;
        ListNode newCur = newHead;
        int pos = 0;
        newHead.next = head;
        while (pos < m - 1) {
            curNode = curNode.next;
            pos++;
        }
        newCur = curNode;
        curNode = curNode.next;
        newCur.next = null;
        while (pos < n) {
            ListNode temp = curNode.next;
            curNode.next = newCur.next;
            newCur.next = curNode;
            curNode = temp;
            pos++;
        }
        while (newCur.next != null) {
            newCur = newCur.next;
        }
        newCur.next = curNode;
        return newHead.next;
    }
}
