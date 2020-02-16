package ExperienceOfferTest2;

public class A55_EntryNodeOfLoop {
    public static void main(String[] args) {
        A55_EntryNodeOfLoop test = new A55_EntryNodeOfLoop();
        ListNode L0 = new ListNode(2);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(7);
        L0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;

        ListNode a = test.EntryNodeOfLoop(L0);
        System.out.println();
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode one = pHead;
        ListNode two = pHead.next.next;
        while (one != two) {
            one = one.next;
            if (two == null || two.next == null) {
                return null;
            }
            two = two.next.next;
        }
        two = two.next;
        int count = 1;
        while (two != one) {
            two = two.next;
            count++;
        }
        one = pHead;
        two = pHead;
        while (count != 0) {
            two = two.next;
            count--;
        }
        while (one != two) {
            one = one.next;
            two = two.next;
        }
        return one;

    }
}
