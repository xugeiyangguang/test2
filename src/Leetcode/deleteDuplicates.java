package Leetcode;



import javax.swing.*;
import java.util.List;

public class deleteDuplicates {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        a1.next = null;
        ListNode re = new deleteDuplicates().deleteDuplicates(a1);
        System.out.println();
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode temp;
        newHead.next = null;
        ListNode cur = head;
        ListNode newCur = newHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int sameValue = cur.val;
                while (cur!= null && cur.val == sameValue) {
                    cur = cur.next;
                }
            } else {
                temp = cur.next;
                cur.next = newCur.next;
                newCur.next = cur;
                newCur = newCur.next;
                cur = temp;
            }

        }
        return newHead.next;

    }
}
