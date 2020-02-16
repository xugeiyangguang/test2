package Leetcode;

import java.util.List;

public class AddListNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l1.next = l11;
        l11.next = l12;
        l12.next = null;
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;
        l22.next = null;
        ListNode re = addTwoNumbers(l1, l2);
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        int one = ToInt(l1);
        int two = ToInt(l2);
        int add = one + two;
        String s = String.valueOf(add);
        ListNode head = new ListNode(0);
        head.next = null;
        for(int i=0;i<s.length();i++){
            ListNode tmp = new ListNode(Integer.valueOf(s.charAt(i))-'0');
            tmp.next = head.next;
            head.next = tmp;

        }
        return head.next;
    }
    public static int ToInt(ListNode l){
        StringBuffer s = new StringBuffer();
        ListNode p = l;
        while(p!=null){
            s.append(p.val);
            p = p.next;
        }
        int re = Integer.valueOf(s.reverse().toString());
        return re;
    }
}
