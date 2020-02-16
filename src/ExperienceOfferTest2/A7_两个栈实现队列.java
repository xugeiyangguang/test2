package ExperienceOfferTest2;

import java.util.ArrayDeque;

public class A7_两个栈实现队列 {
    ArrayDeque<Integer> s1 = new ArrayDeque<>();
    ArrayDeque<Integer> s2 = new ArrayDeque<>();
    public void push(int node) {
        s1.push(node);
    }
    public int pop() {
        if (s2.size() == 0) {
            while (s1.size() != 0) {
                s2.push(s1.poll());
            }
        }
        return s2.poll();
    }
}
