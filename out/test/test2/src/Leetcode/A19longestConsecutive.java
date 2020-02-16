package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class A19longestConsecutive {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0){
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int maxCount = 1;
        for (int i:num
             ) {
            hashSet.add(i);
        }
        for (int i:num
             ) {
            if (hashSet.remove(i)){
                int val = i;
                int max = 1;
                int val_small = val - 1;
                int val_big = val + 1;
                while (hashSet.remove(val_small)){
                    max++;
                    val_small --;
                }
                while (hashSet.remove(val_big)){
                    max++;
                    val_big++;
                }
                maxCount = Math.max(max,maxCount);
            }
        }
        return maxCount;
    }
}
