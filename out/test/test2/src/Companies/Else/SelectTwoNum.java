package Companies.Else;

import java.util.Arrays;

public class SelectTwoNum {
    public static void main(String[] args) {
        int[] a = {5, 6, 7, 2, 3, 9, 4, 8, 1, 2, 0};
        int target = 16;
        Arrays.sort(a);
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] < target) {
                i++;
            } else if (a[i] + a[j] > target) {
                j--;
            } else {
                System.out.println("i=" + a[i] + ",j=" + a[j]);
                return;
            }
        }
    }
}
