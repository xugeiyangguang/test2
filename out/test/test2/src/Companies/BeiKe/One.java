package Companies.BeiKe;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextLong();
        }
        long re = func(a);
        System.out.println(re);

    }
    private static long func(long[] arr) {
        long[] a = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] + 1 > a[i] && arr[i] > arr[j]) {
                    a[i] = a[j] + 1;
                }
            }
        }
        return max(a);
    }

    private static long max(long[] a) {
        long max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }


}
