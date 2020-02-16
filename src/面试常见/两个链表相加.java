package 面试常见;



import java.util.ArrayDeque;
import java.util.ArrayList;

/*两个链表相加，要从链表尾节点开始相加，有一个专门记录进位的int
* */
public class 两个链表相加 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = null;
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(5);
        b1.next = b2;
        b2.next = b3;
        b3.next = null;
        ListNode re = func1(a1, b1);
        ListNode cur = re;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
        }

    }

    /*使用两个栈*/
    public static ListNode func(ListNode a, ListNode b) {
        ArrayDeque<Integer> aa = new ArrayDeque<>();
        ListNode aCur = a;
        while (aCur != null) {
            aa.push(aCur.val);
            aCur = aCur.next;
        }

        ArrayDeque<Integer> bb = new ArrayDeque<>();
        ListNode bCur = b;
        while (bCur != null) {
            bb.push(bCur.val);
            bCur = bCur.next;
        }

        ListNode head = new ListNode(-1);
        int add = 0;
        while (aa.size() != 0 && bb.size() != 0) {
            int tmp = aa.pop() + bb.pop() + add;
            if (tmp > 9) {
                add = 1;
                tmp = tmp - 10;
            } else {
                add = 0;
            }
            ListNode k = new ListNode(tmp);
            k.next = head.next;
            head.next = k;
        }
        int tmp = add;
        if (aa.size() != 0) {
            tmp = aa.pop();
        } else if (bb.size() != 0) {
            tmp = bb.pop();
        }

        if (tmp != 0) {
            if (tmp > 9) {
                ListNode k = new ListNode(tmp - 10);
                k.next = head.next;
                head.next = k;
                k = new ListNode(1);
                k.next = head.next;
                head.next = k;
            } else {
                ListNode k = new ListNode(tmp);
                k.next = head.next;
                head.next = k;
            }
        }

        return head.next;
    }

    /*方法二：先反转两个链表，再使用头插法求值*/
    public static ListNode func1(ListNode a, ListNode b) {
        ListNode aa = Reverse(a);
        ListNode bb = Reverse(b);
        ListNode head = new ListNode(-1);
        head.next = null;
        int add = 0;
        while (aa != null && bb != null) {
            int tmp = aa.val + bb.val + add;
            if (tmp >= 10) {
                add = 1;
                tmp = tmp - 10;
            } else {
                add = 0;
            }
            ListNode k = new ListNode(tmp);
            k.next = head.next;
            head.next = k;
            aa = aa.next;
            bb = bb.next;
        }
        int tmp = add;
        if (aa != null) {
            tmp += aa.val;
        }
        if (bb != null) {
            tmp += bb.val;
        }
        if (tmp > 0) {
            if (tmp >= 10) {
                tmp = tmp - 10;
                ListNode k = new ListNode(tmp);
                k.next = head.next;
                head.next = k;
                k = new ListNode(1);
                k.next = head.next;
                head.next = k;
            } else {
                ListNode k = new ListNode(tmp);
                k.next = head.next;
                head.next = k;
            }
        }
        return head.next;
    }

    /*反转链表*/
    public static ListNode Reverse(ListNode a) {
        ListNode head = new ListNode(-1);
       // ListNode cur = a;
        ListNode tmp;
        while (a != null) {
            tmp = a.next;
            a.next = head.next;
            head.next = a;
            a = tmp;
        }
        return head.next;
    }
}
