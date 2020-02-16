package ExperienceOfferTest2;

import java.util.ArrayDeque;

public class A21_O1区栈的最小值 {
    ArrayDeque<Integer> s = new ArrayDeque<>();
    ArrayDeque<Integer> s1 = new ArrayDeque<>();
    public void push(int node) {
        s.push(node);
        if (s1.size() == 0 || s1.peek() > node) {
            s1.push(node);
        } else {
            s1.push(s1.peek());
        }
    }
    public void pop() {
        s.pop();
        s1.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return s1.peek();
    }
}
