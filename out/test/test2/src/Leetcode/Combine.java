package Leetcode;

import java.util.ArrayList;

public class Combine {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new Combine().combine(3, 3);
        System.out.println();
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        combineCore(1, n, k, list);
        return re;
    }

    ArrayList<ArrayList<Integer>> re = new ArrayList<>();

    public void combineCore(int start, int end, int k, ArrayList<Integer> list) {
        if (k == 0) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            re.add(temp);
            return;
        }
        if (start > end || end - start + 1 < k || list.size() > end) {
            return;
        }

        list.add(start);
        combineCore(start + 1, end, k - 1, list);
        list.remove(list.size() - 1);
        combineCore(start + 1, end, k, list);
    }
}
