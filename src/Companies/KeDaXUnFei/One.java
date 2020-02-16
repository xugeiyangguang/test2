package Companies.KeDaXUnFei;

import java.util.Scanner;

public class One {
    private static int re = 0;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String ss = s.nextLine();
            //    String ss = "{11, 13, 15, 17, 19, 21}";
            ss = ss.substring(1, ss.length() - 1);
            String[] str = ss.split(",");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.valueOf(str[i].trim());
            }

            func(a, 0, a.length - 1, 19);
            if (re == -1) {
                System.out.println(-1);
            } else {
                System.out.println(re + 1);
            }
        }

    }

    public static void func(int[] a, int start, int end,int target) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] < target) {
                func(a, mid + 1, end, target);
            } else if (a[mid] > target) {
                func(a, start, mid - 1, target);
            } else {
                re = mid;
                return;
            }
        } else {
            re = -1;
        }

    }
}
