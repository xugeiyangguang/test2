/*

import java.util.Scanner;

public class Jiang {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int j = s.nextInt();

        int[] a = new int[j+1];
        a[0] = 1;
        int re = 0;
        for (int i = 1; i <= j; i++) {
            a[i] = a[i - 1] * k;
        }

        for (int i = 1; i <= j; i++) {
            re += a[i];
        }

        System.out.println(re%1000);

    }


}
*/
