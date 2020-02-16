package Companies.Else;

import java.util.ArrayList;

public class SortKList {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(7);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(8);
        ListNode a7 = new ListNode(3);
        ListNode a8 = new ListNode(6);
        ListNode a9 = new ListNode(9);
        a1.next = a2;
        a2.next = a3;
        a3.next = null;
        a4.next = a5;
        a5.next = a6;
        a6.next = null;
        a7.next = a8;
        a8.next = a9;
        a9.next = null;
        ListNode p1 = a1;
        ListNode p2 = a4;
        ListNode p3 = a7;
        /*PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });*/
        //采用小顶堆的做法
        /*PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2)->o1.val - o2.val);
        queue.add(p1);
        queue.add(p2);
        queue.add(p3);
        while (queue.size() != 0) {
            ListNode top = queue.poll();
            if (top == p1) {
                p1 = p1.next;
                if (p1 != null) {
                    queue.add(p1);
                }
            }
            if (top == p2) {
                p2 = p2.next;
                if (p2 != null) {
                    queue.add(p2);
                }
            }
            if (top == p3) {
                p3 = p3.next;
                if (p3 != null) {
                    queue.add(p3);
                }
            }
            System.out.print(top.val);
        }*/

        //采用两两合并的方法
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        while (list.size() != 1) {
            ListNode a = list.remove(0);
            ListNode b = list.remove(0);
            list.add(Merge(a, b));
        }
        ListNode re = list.get(0);
        while (re != null) {
            System.out.print(re.val);
            re = re.next;
        }

    }

    public static ListNode Merge(ListNode a, ListNode b) {
        ListNode p1 = a;
        ListNode p2 = b;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode temp;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                temp = p1;
                p1 = p1.next;
            } else {
                temp = p2;
                p2 = p2.next;
            }
            cur.next = temp;
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
