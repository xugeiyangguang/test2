package Companies.Liulishuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        ArrayList<Integer> bb = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = s.nextInt();
            bb.add((b[j] + a[j]) % m);
        }
        Collections.sort(bb);
        Collections.reverse(bb);
        for (int i:bb
             ) {
            System.out.print(i);
            System.out.print(" ");
        }

    }
}
