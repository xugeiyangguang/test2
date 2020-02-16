package Leetcode;

public class A33sortedListToBST {
    public static void main(String[] args) {
        A33sortedListToBST test = new A33sortedListToBST();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        a1.next = a2;
        a2.next = null;
        TreeNode re = test.sortedListToBST(a1);
        System.out.println();
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortedListToBSTCore(head, null);
    }

    public TreeNode sortedListToBSTCore(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode one = head;
        ListNode two = head;
        while (two != tail && two.next != tail) {
            two = two.next.next;
            one = one.next;
        }
        TreeNode a = new TreeNode(one.val);
        a.left = sortedListToBSTCore(head, one);
        a.right = sortedListToBSTCore(one.next, tail);
        return a;
    }
}
