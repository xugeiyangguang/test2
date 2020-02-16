package ExperienceOfferTest2;

import java.util.ArrayDeque;

public class A22_栈的压入和弹出序列 {
    public static void main(String[] args) {
        A22_栈的压入和弹出序列 test = new A22_栈的压入和弹出序列();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {5, 4, 3, 1, 2};
        boolean re = test.IsPopOrder(pushA, popA);
        System.out.println();
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int curPush = 0;
        int curPop = 0;
        while (curPop != popA.length) {
            while (arrayDeque.size() == 0 || arrayDeque.peek() != popA[curPop]) {
                if (curPush == pushA.length) {
                    return false;
                }
                arrayDeque.push(pushA[curPush]);
                curPush++;
            }
            arrayDeque.poll();
            curPop++;
        }
        return true;
    }
}
