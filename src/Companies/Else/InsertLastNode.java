package Companies.Else;

import java.util.ArrayDeque;

public interface InsertLastNode {
    static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = null;
        a5.next = null;
        ListNode re = Insert(a1);
        for (ListNode cur = re; cur != null; cur = cur.next) {
            System.out.print(cur.val);
        }
    }

    static ListNode Insert(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayDeque<ListNode> arrayDeque = new ArrayDeque<>();
        ListNode cur = head;
        int mid = 0;
        while (cur != null) {
            cur = cur.next;
            mid++;
        }
        if (mid <= 2) {
            return head;
        }
        mid = mid / 2 + 1;
        cur = head;
        while (mid != 1) {
            cur = cur.next;
            mid--;
        }
        ListNode a = cur.next;
        cur.next = null;
        cur = a;
        while (cur != null) {
            arrayDeque.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null && arrayDeque.size() > 0) {
            ListNode temp = arrayDeque.pop();
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        return head;
    }
}
