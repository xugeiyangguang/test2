package Leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class 字符串全排列的第K个 {
    public static void main(String[] args) {
        String re = getPermutation1(3, 3);
        System.out.println(re);
    }
    public static String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int[] f = new int[n];
        f[0] = 1;
        for(int i=1;i<n;i++){
            f[i] = f[i-1]*i;
        }
        String re = "";
        for(int i=n;i>0;i--){
            int row = k/f[i-1];
            k = k%f[i-1];
            re+=list.remove(row);
        }
        return re;
    }



    public static String getPermutation1(int n, int k) {
        String res="";
        ArrayList<Integer> list =new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(i+1);
        int[] f = new int[n];
        f[0]=1;
        k--;
        for(int i=1;i<n;i++) f[i]=f[i-1]*i;
        for(int i=n;i>=1;i--){
            int j=k/f[i-1];
            k%=f[i-1];
            res+=list.get(j);
            list.remove(j);
        }
        return res;
    }
}
