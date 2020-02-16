package Companies.ShangTang;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] ss = s.nextLine().split(" ");
        int re = func(ss);
        System.out.println(re);
    }
    public static int func(String[] tt) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String s : tt) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}