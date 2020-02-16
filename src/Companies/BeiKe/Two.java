package Companies.BeiKe;

import java.math.BigInteger;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        BigInteger[] a = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextBigInteger();
        }
        BigInteger min = a[1].subtract(a[0]);
        int pre = 0;
        for (int i = 0; i < n - 1; i++) {

            BigInteger tmp = a[i].subtract(a[i + 1]).abs();
            if (tmp.compareTo(min)<0) {
                pre = i;
                min = tmp;
            }
        }
        System.out.print(a[pre]);
        System.out.print(" ");
        System.out.print(a[pre + 1]);
    }
}
