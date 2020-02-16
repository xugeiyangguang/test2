package Companies.Else;

import java.util.Arrays;
import java.util.Scanner;

public class Competition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
       /* int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int[] a = new int[2];
            a[0] = scanner.nextInt();
            a[1] = scanner.nextInt();
        }
*/
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        int re = 0;
        for (; i < a.length;) {
            if (a[i] > b[j]) {
                re++;
                i++;
                j++;
            } else if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                re--;
                i++;

            }
        }
        System.out.println(re);
    }
}
