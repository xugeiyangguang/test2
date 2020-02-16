package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数组中等于给定数得到子数组 {
    ArrayList<ArrayList<Integer>> re = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        数组中等于给定数得到子数组 test = new 数组中等于给定数得到子数组();
        test.re = test.combinationSum(candidates, 7);
        test.result = test.combinationSum1(candidates, 7);
        System.out.println(test.re);
        System.out.println("------------------");
        System.out.println(test.result);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        func(candidates, target, list, 0);
        return re;
    }

    public void func(int[] candidates, int target, ArrayList<Integer> list, int start) {
        if (target == 0) {
            ArrayList<Integer> tmp = new ArrayList<>(list);
            re.add(tmp);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            func(candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }


    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        backtracking(candidates, target, 0, list);
        return result;
    }

    public void backtracking(int[] candidates, int target, int start, List<Integer> list) {

        if (target < 0) return;
        else if (target == 0) {

            result.add(new ArrayList<>(list));

        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i, list);
                list.remove(list.size() - 1);
            }
        }

    }
}
