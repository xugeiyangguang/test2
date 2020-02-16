package Leetcode;

public class Merge {
    public static void main(String[] args) {

    }
    public void merge(int A[], int m, int B[], int n) {
        if (A.length < m + n) {
            return;
        }
        int Aindex = m - 1;
        int Bindex = n - 1;
        int curIndex = A.length - 1;
        while (Aindex >= 0 && Bindex >= 0) {
            if (A[Aindex] > B[Bindex]) {
                A[curIndex--] = A[Aindex--];
            } else {
                A[curIndex--] = B[Bindex--];
            }
        }
        while (Bindex >= 0) {
            A[curIndex--] = B[Bindex--];
        }
    }
}
