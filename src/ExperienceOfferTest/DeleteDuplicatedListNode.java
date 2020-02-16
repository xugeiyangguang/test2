package ExperienceOfferTest;

import java.util.List;
import java.util.function.LongUnaryOperator;

public class DeleteDuplicatedListNode {
    public static void main(String[] args) {
        DeleteDuplicatedListNode test = new DeleteDuplicatedListNode();
        ListNode L0 = new ListNode(2);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(7);
        L0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        /*if (test.deleteDuplication(l3)!=null){

        }*/
        ListNode a = test.deleteDuplication(L0);
        System.out.println();

    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        while (cur!=null&&cur.next!=null){
            if (cur.val!=cur.next.val){
                pre = pre.next;
                cur = cur.next;
            }else {
                int temp = cur.val;
                while (cur != null&&cur.val == temp){
                    cur = cur.next;
                }
                pre.next = cur;
            }

        }
        return newHead.next;
    }
}
