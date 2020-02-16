package Leetcode;

public class A30LinkPartition {
    public static void main(String[] args) {
        A30LinkPartition test = new A30LinkPartition();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = null;
        ListNode re = test.partition(a1, 3);
        System.out.println();
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode small = new ListNode(0);
        ListNode smallcur = small;
        small.next = null;
        ListNode greater = new ListNode(1);
        greater.next = null;
        ListNode greatercur = greater;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                smallcur.next = cur;
                smallcur = smallcur.next;
            } else {
                greatercur.next = cur;
                greatercur = greatercur.next;
            }
            cur = cur.next;
        }
        smallcur.next = greater.next;
        greatercur.next = null;
        return small.next;
    }
}
