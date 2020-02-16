package Leetcode;

public class A1DetectCycle {
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode circleNode = MidNode(head);
        if (circleNode == null){
            return null;
        }

        int circleNodeCount = 1;
        ListNode temp = circleNode.next;
        while (temp != circleNode){
            circleNodeCount++;
            temp = temp.next;
        }

        ListNode preNode = head;
        while (circleNodeCount > 0){
            preNode = preNode.next;
            circleNodeCount--;
        }
        ListNode lastNode = head;
        while (lastNode != preNode){
            lastNode = lastNode.next;
            preNode = preNode.next;
        }
        return lastNode;

    }
    //找到一个环中的节点  , 此时的链表至少有两个节点
    public ListNode MidNode(ListNode head){
        ListNode oneStep = head.next;
        ListNode twoStep = head.next.next;
        while (oneStep != twoStep){
            if (twoStep == null || twoStep.next == null){
                return null;
            }else {
                oneStep = oneStep.next;
                twoStep = twoStep.next.next;
            }
        }
        return oneStep;
    }
}
