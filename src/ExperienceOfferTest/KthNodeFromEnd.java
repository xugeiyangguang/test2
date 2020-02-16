package ExperienceOfferTest;

import java.util.Collections;

public class KthNodeFromEnd {
    public static void main(String[] args){

        ListNode L0 = new ListNode(2);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(7);
        L0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        if((FindKthToTail(L0,-1)!=null)){
            System.out.println(FindKthToTail(L0,-1).val);
        }

    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        /*链表是否为空*/
        if(head == null){
            return null;
        }
        /*输入K不能大于长度,,在这里写出来的运行时间比在里面更快，可能是里面需要每次验证？*//*
        ListNode lenTest = head;
        int len = 0;
        while (lenTest!=null){
            lenTest = lenTest.next;
            len++;
        }
        if(k > len){
            return null;
        }*/

        /*k的输入要合法*/
        if(k <= 0){
            System.out.println("Wrong!");
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for(int i = 0; i < k-1; i++){
            if(last.next!=null){
                last = last.next;
            }else {    /*输入K不能大于长度*/
                return null;
            }
        }
        while (last.next!=null){
            pre = pre.next;
            last = last.next;
        }
        return pre;
    }
}
