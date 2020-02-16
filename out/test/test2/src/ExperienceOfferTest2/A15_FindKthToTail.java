package ExperienceOfferTest2;

import java.util.List;

public class A15_FindKthToTail {
    public static void main(String[] args) {
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 1; i < k; i++) {
            if (second.next != null) {
                second = second.next;
            } else {
                return null;
            }
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
