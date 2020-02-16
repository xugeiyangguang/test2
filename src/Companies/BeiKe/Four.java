package Companies.BeiKe;

import java.util.Arrays;
import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        int[] len = new int[n];
        len[0] = 1;
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            for (; j >= 0 && a[j] > a[i]; j--) ;
            if (j >= 0) {
                len[i] = len[j] + 1;
            } else {
                len[i] = 0;
            }
        }
        Arrays.sort(len);
        System.out.println(len[len.length - 1]);
    }


}
