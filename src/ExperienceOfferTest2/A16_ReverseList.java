package ExperienceOfferTest2;

public class A16_ReverseList {
    public static void main(String[] args) {


    }
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }
        return newHead.next;
    }
}
