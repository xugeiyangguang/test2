package Leetcode;

import java.util.ArrayList;

public class A25getRow {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> re = new ArrayList<>();
        re.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = re.size() - 2; j >= 0; j--) {
                re.set(j + 1, re.get(j) + re.get(j + 1));
            }
            re.add(1);
        }
        return re;
    }
}
