package Companies.ShangTang;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        int max = 1;
        for (int i = 1; i < a.length-1; i++) {
            int tmp = 1;
            for (int j=i-1;j>=0;j--){
                if (a[j] < a[j+1]) {
                    tmp++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[j-1]) {
                    tmp++;
                } else {
                    break;
                }
            }
            max = Math.max(max, tmp);
        }
        if (max < 3) {
            System.out.println(0);

        } else {
            System.out.println(max);
        }


    }
}
