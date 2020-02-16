package Leetcode;

public class SortLinkList4 {
    public static void main(String[] args) {
        SortLinkList4 test = new SortLinkList4();
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode re = test.sortList(a1);
        System.out.println();
        System.out.println();
    }

    /**
     * 考点：1.根据时间和空间复杂度，选择归并排序
     *   2.使用快慢指针查找链表的中点
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {    //将链表不断从中间分成两个部分
        if (head == null || head.next == null){
            return head;
        }
        ListNode middle = MiddleNode(head);
        ListNode List2 = middle.next;
        middle.next = null;
        return MergeList(sortList(head),sortList(List2));
    }

    //将两个链表合并
    public ListNode MergeList(ListNode List1,ListNode List2){
        if (List1 == null){
            return List2;
        }
        if (List2 == null){
            return List1;
        }
        ListNode p1 = List1;
        ListNode p2 = List2;
        ListNode newHead;
        if (p1.val < p2.val){
            newHead = p1;
            p1 = p1.next;
        }else {
            newHead = p2;
            p2 = p2.next;
        }
        ListNode cur = newHead;
        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                cur.next = p1;
                p1 = p1.next;
            }else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null){
            cur.next = p1;
        }
        if (p2 != null){
            cur.next = p2;
        }
        return newHead;
    }

    //使用快慢指针查找链表的中间节点
    public ListNode MiddleNode(ListNode head){
        ListNode oneNode = head;
        ListNode twoNode = head;
        while (twoNode.next != null && twoNode.next.next != null){
            oneNode = oneNode.next;
            twoNode = twoNode.next.next;
        }
        return oneNode;
    }
}
