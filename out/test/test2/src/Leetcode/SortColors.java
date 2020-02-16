package Leetcode;

public class SortColors {
    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        new SortColors().sortColors(A);
        System.out.println();
    }
    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int index0 = 0;
        int index2 = A.length - 1;
        for (int i = 0; i < index2 + 1; i++) {
            if (A[i] == 0) {
                swap(A, i, index0);
                index0++;
            } else if (A[i] == 2) {
                swap(A, i, index2);
                i--; //和2交换的，该位置需要再次检查
                index2--;
            }
        }
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
