package Companies.yuewen;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        Arrays.sort(a);
        int re = 0;
        for (int i = 0; i < m; i++) {
            re += a[i];
        }
        System.out.println(re);
    }

}
