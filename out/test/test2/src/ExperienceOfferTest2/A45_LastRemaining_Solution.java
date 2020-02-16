package ExperienceOfferTest2;

import java.util.List;

public class A45_LastRemaining_Solution {
    public static void main(String[] args) {
        A45_LastRemaining_Solution test = new A45_LastRemaining_Solution();
        int re = test.LastRemaining_Solution(5, 3);
        System.out.println();

    }
    public int LastRemaining_Solution(int n, int m) {
        if (m < 1) {
            return -1;
        }
        ListNode head = new ListNode(-1);
        ListNode last = new ListNode(n - 1);
        last.next = head.next;
        head.next = last;
        for (int i = 1; i < n; i++) {
            ListNode temp = new ListNode(n - i - 1);
            temp.next = head.next;
            head.next = temp;
        }
        //将链表构成环
        last.next = head.next;
        ListNode curNode = head.next;
        while (curNode.next != curNode) {
            int count = 0;
            while (count < m - 2) {
                curNode = curNode.next;
                count++;
            }
            curNode.next = curNode.next.next;
            curNode = curNode.next;
        }
        return curNode.val;
    }
}
