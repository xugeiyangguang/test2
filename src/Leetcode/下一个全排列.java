package Leetcode;

import java.util.Arrays;

public class 下一个全排列 {
    public static void main(String[] args) {
        int[] num = {1, 5, 1};
        nextPermutation(num);
        System.out.println();
    }

    public static void nextPermutation(int[] num) {
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                //  int index=  i+1;
                int j = i + 1;
                for (; j < num.length; j++) {
                    if (num[j] <= num[i]) {
                        break;
                    }
                }
                j--;
                int tmp = num[j];
                num[j] = num[i];
                num[i] = tmp;
                Arrays.sort(num, i + 1, num.length);
                return;
            }
        }
        Arrays.sort(num);

    }
}
