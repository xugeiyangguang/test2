package Companies.ShangTang;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Tiam {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] ss = s.nextLine().split(" ");
        int re = func(ss);
        System.out.println(re);
    }
    public static int func(String[] tt) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < tt.length; i++) {
            String s = tt[i];
            if (s.equals("+")) {
                deque.push(deque.pop() + deque.pop());
            } else if (s.equals("-")) {
                deque.push(-deque.pop() + deque.pop());
            } else if (s.equals("*")) {
                deque.push(deque.pop() * deque.pop());
            } else if (s.equals("/")) {
                int n = deque.pop();
                deque.push(deque.pop() / n);
            } else {
                deque.push(Integer.valueOf(s));
            }
        }
      
        return deque.pop();
    }

}
