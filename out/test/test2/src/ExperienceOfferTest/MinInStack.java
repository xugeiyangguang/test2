package ExperienceOfferTest;

import java.util.Stack;

public class MinInStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> s1 = new Stack();   //存储当前所有最小值
    public void push(int node) {
        s.push(node);
        if(s1.size() == 0||node < s1.peek()){
            s1.push(node);
        }else{
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
    public static void main(String[] args){
        MinInStack temp = new MinInStack();
        temp.push(5);
        temp.push(3);
        temp.push(1);
        System.out.print(temp.top());
        System.out.print(temp.min());

    }
}
