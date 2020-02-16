package Leetcode;

import java.util.List;

public class 以k间隔翻转链表 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        a2.next = null;
        ListNode re = reverseKGroup(a1, 3);
        System.out.println();
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<0){
            return null;
        }
        if(k==1){
            return head;
        }
        ListNode tmpHead = new ListNode(-1);
        tmpHead.next = null;
        ListNode newHead =  new ListNode(-1);
        ListNode last  = newHead;
        ListNode cur = head;
        while(cur!=null){

            int i=k;
            for(;i>0&&cur!=null;i--){
                ListNode tmp = cur.next;
                cur.next = tmpHead.next;
                tmpHead.next = cur;
                cur = tmp;
            }
            if(i>0){
                //再次使用头插法翻转
                ListNode tmp = tmpHead.next;
                while (tmp != null) {
                    ListNode tt = tmp.next;
                    tmp.next = last.next;
                    last.next = tmp;
                    tmp = tt;
                }

                break;
            }else{
                last.next = tmpHead.next;
                while(last.next!=null){
                    last = last.next;
                }
                tmpHead.next = null;
            }
        }
        return newHead.next;
    }
}
