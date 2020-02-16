package Companies.Else;

import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] count = new int[1];
        func(s, count);
        System.out.println(count[0]);
    }

    public static void func(String s,int[] count) {
        if (s == null | s.length() == 0) {
            return ;
        }

        if (s.length() <= 2) {
            if (Integer.valueOf(s) <= 26 && s.length() == 2) {
                count[0] += 2;
            } else {
                count[0] += 1;
            }
            return;
        }


        if (s.length() > 1 && Integer.valueOf(s.substring(0, 2)) <= 26) {
            func(s.substring(2), count);
        }
        func(s.substring(1), count);
        return;
    }
}
