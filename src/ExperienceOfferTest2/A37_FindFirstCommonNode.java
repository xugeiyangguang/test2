package ExperienceOfferTest2;

public class A37_FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0;
        for (ListNode temp = pHead1; temp != null; temp = temp.next) {
            len1++;
        }
        int len2 = 0;
        for (ListNode temp = pHead2; temp != null; temp = temp.next) {
            len2++;
        }
        int k = len1 - len2;
        ListNode quick = k > 0 ? pHead1 : pHead2;
        int more = k;
        while (more > 0) {
            quick = quick.next;
            more--;
        }
        ListNode other = k > 0 ? pHead2 : pHead1;
        while (quick != other) {
            quick = quick.next;
            other = other.next;
        }
        if (quick == null) {
            return null;
        }
        return quick;
    }


}
