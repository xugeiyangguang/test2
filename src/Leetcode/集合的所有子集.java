package Leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class 集合的所有子集 {
    public static void main(String[] args) {
        int[] s = {1};
        ArrayList<ArrayList<Integer>> re = subsets(s);
        System.out.println(re);
    }
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        int n = S.length;
        for(int i=0;i<Math.pow(2,n);i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            int mask = 1;
            for(int j=0;j<n;j++){
                if((mask&i)!=0){
                    tmp.add(S[j]);
                }
                mask <<=1;
            }
            Collections.sort(tmp);
            re.add(tmp);
        }
        return re;
    }
}
