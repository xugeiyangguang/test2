package ExperienceOfferTest;

import ExperienceOfferTest.ListNode;

import java.util.ArrayList;
import java.util.Collections;  /*引入*/

public class Solution3 {
    public static void main(String[] args){
        ListNode L = new ListNode(2);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        L.next = l1;
        l1.next = l2;
        l2.next = null;
        System.out.println(printListFromTailToHead(L));
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();  /*ArrayList不能静态使用？*/
        /*if (listNode!=null){
            if(listNode.next!=null){
                printListFromTailToHead(listNode.next);
            }
            list.add(listNode.val);
        }*/
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        /*想要翻转，但是自身没有这个方法，可以借助它的父类Collections*/
        Collections.reverse(list);
        return list;
    }
}