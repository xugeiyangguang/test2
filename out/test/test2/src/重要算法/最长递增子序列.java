package 重要算法;

import java.util.Arrays;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 1, 5, 6};
        int re = func(a);
        System.out.println();
    }

    public static int func(int[] a) {
        int[] tmp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            tmp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && tmp[j] + 1 > tmp[i]) {
                    tmp[i] = tmp[j] + 1;
                }
            }
        }
        Arrays.sort(tmp);
        return tmp[tmp.length - 1];
    }
}
