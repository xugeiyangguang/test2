package Companies.Liulishuo;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] s1 = s.nextLine().split(" ");
        String[] s2 = s.nextLine().split(" ");
        int[] a1 = new int[s1.length];
        int[] a2 = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            a1[i] = Integer.valueOf(s1[i]);
            a2[i] = Integer.valueOf(s2[i]);
        }
        int re = 1;
        for (int i = 1; i < s1.length; i++) {
            int tmp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (a1[i] < a2[j]) {
                    tmp++;
                } else {
                    break;
                }
            }
            re = Math.max(re, tmp);
        }
        System.out.println(re);
    }
}
