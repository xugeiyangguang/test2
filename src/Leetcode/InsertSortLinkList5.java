package Leetcode;

public class InsertSortLinkList5 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        InsertSortLinkList5 test = new InsertSortLinkList5();
        ListNode re = test.insertionSortList(a1);
        System.out.println();
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode oldCur = head;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = null;
        ListNode newCur = newHead;
        while (oldCur != null){
            while (newCur.next != null && newCur.next.val < oldCur.val){
                newCur = newCur.next;
            }
            ListNode temp = oldCur;
            oldCur = oldCur.next;
            temp.next = newCur.next;
            newCur.next = temp;
            newCur = newHead;
        }
        return newHead.next;
    }
}
