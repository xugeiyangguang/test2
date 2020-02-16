
package 重要算法;

public class 链表快排 {
    public static void main(String[] args) {
        ListNode a0 = new ListNode(4);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(9);
        ListNode a6 = new ListNode(0);
        ListNode a7 = new ListNode(1);
        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = null;
   //     SortQuick(a0, null);
        ListNode kk = func4(a0,null);
        ListNode tmp = kk;
        while (tmp != null) {
            System.out.print(tmp.val);
            tmp = tmp.next;
        }
    }

    public static void SortQuick(ListNode head,ListNode end) {
        if (head != end) {
            ListNode tmp = func1(head, end);
            SortQuick(head, tmp);
            SortQuick(tmp.next, end);
        }
    }


/*方法一：双指针从左边开始，如果j<key则两个同时向前，否则只有 j向前
    * */

    public static ListNode func2(ListNode head,ListNode end) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode j = head.next;
        ListNode i = head;
        while (j != end) {
            if (j.val <= head.val) {
                j = j.next;
                i = i.next;
            } else {
                while (j != end && j.val > head.val) {
                    j = j.next;
                }
                if (j != end) {
                    i = i.next;
                    int tmp = i.val;
                    i.val = j.val;
                    j.val = tmp;
                }
            }


        }
        int tmp = head.val;
        head.val = i.val;
        i.val = tmp;
        return i;
    }


/*方法二：郭大佬的把一个链表分成两个，再把他们接起来,有问题
    * */

    public static ListNode func1(ListNode head,ListNode end) {
        if (head == end) {
            return head;
        }
        int key = head.val;
        ListNode newHead = new ListNode(-1);
        ListNode small = newHead;
        ListNode bigHead = new ListNode(-1);
        ListNode big = bigHead;
        ListNode cur = head.next;
        while (cur != end) {
            if (cur.val < key) {
                small.next = cur;
                small = small.next;
            } else {
                big.next = cur;
                big = big.next;
            }
            cur = cur.next;
        }
        big.next = end;
        small.next = head;
        head.next = bigHead.next;
        newHead.next = func1(newHead.next,head);
        func1(bigHead.next, end);

        return newHead.next;
    }

    /*方法四：采用头插法将小于基准的值插在前面*/
    public static ListNode func4(ListNode head,ListNode end) {
        if (head == null || head == end) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = head.next;
        head.next = end;
        ListNode index = head;
        while (cur != end) {
            ListNode tmp = cur.next;
            if (cur.val < index.val) {
                cur.next = newHead.next;
                newHead.next = cur;
            } else {
                cur.next = index.next;
                index.next = cur;
            }
            cur = tmp;
        }
        /*要把首尾接起来*/
        newHead.next = func4(newHead.next, index);
        index.next = func4(index.next, end);
        return newHead.next;
    }


/*方法三：归并排序
    * */

    public static ListNode func3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = FindMid(head);
        ListNode second = mid.next;
        mid.next = null;
        head = func3(head);
        second = func3(second);
        head = Merge(head, second);
        return head;
    }


/*找到链表的中间节点
    * */
    public static ListNode FindMid(ListNode a) {
        ListNode one = a;
        ListNode two = a;
        while (two.next != null && two.next.next != null) {
            one = one.next;
            two = two.next.next;
        }
        return one;
    }

/*合并两个有序链表
    * */

    public static ListNode Merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode p1 = a;
        ListNode p2 = b;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return head.next;
    }


}


