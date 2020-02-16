package Leetcode;

public class RotateLinkList {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        a2.next = null;
        ListNode re = rotateRight(a1, 1);
        System.out.println();
    }
    public static ListNode rotateRight(ListNode head, int n) {
        if(head==null||n<0){
            return null;
        }
        ListNode one = head;
        int len = 0;
        while(one!=null){
            one = one.next;
            len++;
        }
        one = head;
        n = n%len;
        if(n==0){
            return head;
        }
        ListNode two = head;
        while(n>0){
            two = two.next;
            n--;
        }
        while(two.next!=null){
            two = two.next;
            one = one.next;
        }
        two.next = head;
        ListNode re = one.next;
        one.next = null;
        return re;
    }
}
