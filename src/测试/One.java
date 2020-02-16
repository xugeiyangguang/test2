package 测试;

import java.util.HashSet;

public class One {
    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        int k = 4;
        func(a, 0, a.length - 1, k - 1);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (set.contains(b[i])) {
                System.out.print(b[i]);
            }
        }
    }

    public static void func(int[] a, int left, int right, int k) {
        if (a == null || a.length == 0 || left >= right) {
            return ;
        }

        int index = funcCore(a, left, right);
        if (index >= k) {
            return;
        } else {
            func(a, index + 1, right, k - index);
        }

    }

    public static int funcCore(int[] a, int left, int right) {

        int key = a[left];
        while (left < right) {
            while (left < right && a[right] >= key) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= key) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = key;
        return left;
    }

}
