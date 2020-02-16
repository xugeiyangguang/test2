package Leetcode;

public class A15SingleOne1 {
    public int singleNumber(int[] A) {
        int re = 0;
        for (int i =0; i < A.length; i++){
            re ^= A[i];
        }
        return re;
    }
}
