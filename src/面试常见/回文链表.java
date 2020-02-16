package 面试常见;

public class 回文链表 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a5 = new ListNode(2);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(6);
        a1.next = null;
        a2.next = a5;
        a5.next = a3;
        a3.next = a4;
        a4.next = null;
        Boolean re = func(a1);
        System.out.println(re);
    }

    public static boolean func(ListNode head) {
        ListNode k = head;
        int len = 0;
        while (k != null) {
            len++;
            k = k.next;
        }
        ListNode mid = findMid(head);
        ListNode newHead = new ListNode(-1);
        newHead.next = null;

        ListNode oldCur = head;
        //将中点前面的节点全部采用头插法反转
        while (oldCur != mid) {
            ListNode tmp = oldCur.next;
            oldCur.next = newHead.next;
            newHead.next = oldCur;
            oldCur = tmp;
        }
        if (len % 2 == 1) {   //奇数长度
            mid = mid.next;
        }
        ListNode newCur = newHead.next;
        //只有一个节点的时候
        if (mid == null && newCur == null) {
            return true;
        } else {
            while (mid != null && newCur != null) {
                if (mid.val != newCur.val) {
                    return false;
                }
                mid = mid.next;
                newCur = newCur.next;
            }
            if (mid != null || newCur != null) {
                return false;
            }
            return true;
        }

    }

    //找到后面的中点
    public static ListNode findMid(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one;
    }
}
