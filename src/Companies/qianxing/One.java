package Companies.qianxing;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] pid = s.nextLine().split(" ");
        String[] ppid = s.nextLine().split(" ");
        String n = s.nextLine();
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer(n);
        int count = 0;
        int flag = 0;
        for (int k = 0; k < ppid.length; k++) {
            if (ppid[k].equals(n)) {
                flag = 1;
                break;
            }
        }
        for (int k = 0; k < pid.length; k++) {
            if (pid[k].equals(n)) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println(0);
            return;
        }
        while(deque.size()!=0){
            int curLen = deque.size();
            count += curLen;
            while (curLen != 0) {
                String tmp = deque.poll();
                for (int i = 0; i < ppid.length; i++) {
                    if (ppid[i].equals(tmp)) {
                        deque.offer(pid[i]);
                    }
                }
                curLen--;
            }

        }
        System.out.println(count);


    }


}
