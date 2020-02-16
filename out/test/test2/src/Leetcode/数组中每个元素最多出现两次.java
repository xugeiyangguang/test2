package Leetcode;

import java.util.ArrayList;

public class 数组中每个元素最多出现两次 {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2};
        int re = removeDuplicates(A);
        System.out.println();
    }
    public static int removeDuplicates(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        if(A.length<=2){
            return A.length;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        int j=i+1;
        for(;i<A.length&&j<A.length;){
            if(A[i]!=A[j]){
                list.add(A[i]);
                i++;
                j++;

            }else{
                while(j<A.length&&A[j]==A[i]){
                    j++;
                }
                list.add(A[i]);
                list.add(A[i]);
                i = j;
                j = j+1;
            }
            if(j>=A.length&&i==A.length-1){
                list.add(A[i]);
                break;
            }

        }
        int[] B = new int[list.size()];
        for(int k=0;k<B.length;k++){
            B[k] = list.get(k);
        }
        A=B;
        int re = list.size();
        return re;
    }
}
