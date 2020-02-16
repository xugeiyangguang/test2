package ExperienceOfferTest2;

import ExperienceOfferTest2.ListNode;

public class A57_deleteDuplication {

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
