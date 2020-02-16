package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class A24generate {
    public static void main(String[] args) {
        A24generate test = new A24generate();
        ArrayList<ArrayList<Integer>> result = test.generate(0);
        System.out.println();

    }
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if (numRows <= 0){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> a0 = new ArrayList<>();
        a0.add(1);
        result.add(a0);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> a1 = new ArrayList<>();
            a1.add(1);
            int preLen = result.get(i-1).size();
            for (int j = 0; j < preLen; j++) {
                if (j == preLen - 1) {
                    a1.add(1);
                } else {
                    a1.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
                }
            }
            result.add(a1);
        }
        return result;
    }
}
