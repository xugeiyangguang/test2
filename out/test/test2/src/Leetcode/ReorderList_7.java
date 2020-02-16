package Leetcode;

import java.util.ArrayDeque;

public class ReorderList_7 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = null;
        ReorderList_7 test = new ReorderList_7();
        test.reorderList(a4);
        System.out.println();
    }
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        ArrayDeque<ListNode> s = new ArrayDeque<>();

        //找到链表的中间节点
        ListNode oneStep = head;
        ListNode twoStep = head;
        while (twoStep != null && twoStep.next != null && twoStep.next.next != null){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        ListNode stackNode = oneStep.next;   //将中间节点以后的节点入栈

        oneStep.next = null;     //将链表分为两部分
        while (stackNode != null){//将后半部分表加入栈中

            ListNode temp = stackNode.next;
            stackNode.next = null;
            s.push(stackNode);
            stackNode = temp;
        }

        //将栈中的节点以间隔一的方式插入前半段序列
        ListNode curNode = head;
        while (s.size() != 0){
            ListNode top = s.poll();
            if (top == null){
                break;
            }
            top.next = curNode.next;
            curNode.next = top;
            curNode = top.next;
        }
    }
}
