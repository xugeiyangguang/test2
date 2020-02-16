package Companies.Kuaishou;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int cur = s.nextInt();
            System.out.println(func(cur, 1));
        }
    }

    public static boolean func(int n,int count) {
        if (count == 1000) {
            return false;
        }
        String s = String.valueOf(n);
        int re = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - '0';
            re += Math.pow(tmp, 2);
        }
        if (re == 1) {
            return true;
        }
        return func(re, count + 1);
    }
}
