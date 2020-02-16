package Leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {
    public static void main(String[] args) {
        int[] S = {1,2};
        ArrayList<ArrayList<Integer>> a = new Subsets().subsets(S);
        System.out.println();
    }
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null || S.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        subsetsCore(S, 0, list);
        Collections.reverse(re);
        return re;
    }

    ArrayList<ArrayList<Integer>> re = new ArrayList<>();
    public void subsetsCore(int[] s, int index, ArrayList<Integer> list) {
        if (index >= s.length) {
            Collections.sort(list);
            ArrayList<Integer> temp = new ArrayList<>(list);
            re.add(temp);
            return;
        }

        list.add(s[index]);
        subsetsCore(s, index + 1, list);
        list.remove(list.size() - 1);
        subsetsCore(s, index + 1, list);

    }
}
