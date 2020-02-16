package ExperienceOfferTest2;

public class A26_复杂链表的复制 {
    public static void main(String[] args) {
        A26_复杂链表的复制 test = new A26_复杂链表的复制();
        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        RandomListNode a5 = new RandomListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;
        a1.random = a3;
        a2.random = a5;
        a4.random = a2;
        RandomListNode re = test.Clone(a1);
        System.out.println();
    }
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        CopyNode(pHead);
        CopyLink(pHead);
        return disparate(pHead);
    }

    //复制链表的节点
    public void CopyNode(RandomListNode phead) {
        RandomListNode curNode = phead;
        while (curNode != null) {
            RandomListNode temp = new RandomListNode(curNode.label);
            temp.next = curNode.next;
            curNode.next = temp;
            curNode = temp.next;
        }
    }

    //复制指针
    public void CopyLink(RandomListNode phead) {
        RandomListNode curNode = phead;
        while (curNode != null) {
            if (curNode.random != null) {
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }
    }

    public RandomListNode disparate(RandomListNode phead) {
        RandomListNode oldHead = phead;
        RandomListNode newHead = phead.next;
        RandomListNode re = newHead;
        while (newHead.next != null) {
            oldHead.next = newHead.next;
            oldHead = oldHead.next;
            newHead.next = oldHead.next;
            newHead = newHead.next;
        }
        oldHead.next = null;
        newHead.next = null;
        return re;
    }


}
