package Companies.ToutTiao;

import java.util.ArrayList;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
         //   money[i] = 100;
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && a[i] > a[i + 1]) {
                int start = i;
                while (i + 1 < n && a[i] >= a[i + 1]) {
                    i++;
                }
                int end = i;
                money[end] = 100;
                for (int j = end-1; j >= start; j--) {
                    if (a[j] == a[j + 1]) {
                        money[j] = money[j + 1];
                    } else {
                        money[j] = money[j + 1] + 100;
                    }
                    //money[j] = money[j + 1] + 100;
                }
                if (end + 1 < n) {
                    money[end + 1] = 200;
                }
            }
        }
        money[0] = 100;
        for (int i = 0; i < n; i++) {
            if (money[i] == 0) {
                if (a[i] == a[i - 1]) {
                    money[i] = money[i - 1];
                } else {
                    money[i] = money[i - 1] + 100;
                }
            }
        }
        int result = 0;
        for (int i:money
             ) {
            System.out.print(i+" ");
            result += i;
        }
        System.out.println(result);
    }
}
