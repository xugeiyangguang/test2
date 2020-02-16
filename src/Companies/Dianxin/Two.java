package Companies.Dianxin;

import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String sss="[2, 4, -2, 5, -6]";
        String[] ss = s.nextLine().substring(1,sss.length()-2).split(",");
        int[] a = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            a[i] = Integer.valueOf(ss[i].trim());
        }
   //     Arrays.sort(a);
        int max = a[0];
        int curSum = a[0];

        for (int i = 1; i < a.length; i++) {
            if (curSum < 0) {
                curSum = a[i];
            } else {
                curSum += a[i];
            }
            max = Math.max(max, curSum);
        }
        System.out.println(max);
    }
}
