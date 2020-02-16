package Companies;

import java.util.Scanner;

public class PDDOne {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = s.nextInt();
        }
        int re = 0;
        for (int j = 0; j <= n/2; j++) {
            re += a[j] * a[2 * n - j - 1];
        }
        System.out.println(re);
    }
}
