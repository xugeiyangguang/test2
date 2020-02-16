package Leetcode;

public class A2HasCycle {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode oneStep = head.next;
        ListNode twoStep = head.next.next;
        while (oneStep != twoStep){
            if (twoStep == null || twoStep.next == null){
                return false;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return true;
    }
}
