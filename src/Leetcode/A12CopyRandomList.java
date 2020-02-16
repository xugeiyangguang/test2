package Leetcode;

public class A12CopyRandomList {
    public static void main(String[] args) {
        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = null;
        a3.random = a2;
        A12CopyRandomList test = new A12CopyRandomList();
        RandomListNode re = test.copyRandomList(a1);
        System.out.println();
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null){
            return null;
        }
        copyNode(head);
        setRandomClue(head);
        return detachList(head);
    }

    public void copyNode(RandomListNode head){

        RandomListNode curNode = head;
        while (curNode != null){
            RandomListNode a = new RandomListNode(0);
            a.label = curNode.label;
            a.next = curNode.next;
            curNode.next = a;
            curNode = a.next;
        }
    }
    public void setRandomClue(RandomListNode head){
        RandomListNode curNode = head;
        while (curNode != null){
            if (curNode.random != null){
                curNode.next.random = curNode.random.next;
            }
            curNode = curNode.next.next;
        }
    }

    public RandomListNode detachList(RandomListNode head){
        RandomListNode newHead = head.next;
        RandomListNode oldCur = head;
        RandomListNode newCur = head;
        while (oldCur.next != null){
            oldCur.next = newCur.next;
            oldCur = newCur.next;
            newCur.next = oldCur.next;
            newCur = oldCur.next;
        }
        return newHead;
    }
}
