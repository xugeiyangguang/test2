package 面试常见;

import java.util.Arrays;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] a = {5, 6, 7, 1, 2, 8};
        int re = func(a);
        System.out.println(re);
    }

    public static int func(int[] a) {
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && arr[j] + 1 > arr[i]) {
                    arr[i] = arr[j] + 1;
                }
            }
        }
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }
}
