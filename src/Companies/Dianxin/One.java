package Companies.Dianxin;

import java.util.Arrays;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        Arrays.sort(a);
        if (a.length % 2 == 1) {
            System.out.println(a[(a.length - 1) / 2]);
        } else {
            System.out.println(a[(a.length - 1) / 2] + a[(a.length - 1) / 2 + 1]);
        }

    }
}
