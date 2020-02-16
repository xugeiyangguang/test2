package ExperienceOfferTest;

public class EntryNodeInListLoop {
    public static void main(String[] args) {
        EntryNodeInListLoop test = new EntryNodeInListLoop();
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
        l5.next = null;

        ListNode a = test.EntryNodeOfLoop(null);
       /* System.out.println();
        System.out.println(a.val);*/
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null){
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        int count = LoopNodeCount(pHead);
        if (count==0){
            return null;
        }
        int i = 0;
        while (i<count){
            p1 = p1.next;
            i++;
        }
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    //找到一个环中的节点，统计环中节点数目
    public int LoopNodeCount(ListNode pHead){
        ListNode p1 = pHead.next;
        ListNode p2 = pHead;
        while (p1!=p2&&p1!=null&&p1.next!=null){
            p1 = p1.next.next;
            p2 = p2.next;
        }
        if (p1==null||p1.next==null){
            return 0;
        }
        int count = 1;
        p1 = p1.next;
        while (p1!=p2){
            count++;
            p1 = p1.next;
        }
        return count;
    }

}
