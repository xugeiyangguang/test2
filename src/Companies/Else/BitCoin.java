package Companies.Else;

import java.util.Scanner;

public class BitCoin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] ss = str.split(" ");
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.valueOf(ss[i]);
        }
        int end = arr.length - 1;
        int max = Integer.MIN_VALUE;
        for (int index = end - 1; index >= 0; index--) {
            if (arr[index] >= arr[end]) {
                end = index;
            } else {
                max = Math.max(arr[end] - arr[index], max);
            }
        }
        if (max < 0) {
            max = 0;
        }
        System.out.println(max);
    }
}
