package ExperienceOfferTest2;

public class A17_MergeSortedList {
    public static void main(String[] args) {

    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        return head.next;

    }
}
