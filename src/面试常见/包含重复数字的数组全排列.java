package 面试常见;

import java.util.ArrayList;

public class 包含重复数字的数组全排列 {
    public static void main(String[] args) {
        int[] num = {1, 1, 1};
        ArrayList<ArrayList<Integer>> re = permuteUnique(num);
        System.out.println(re);
    }

    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        func(num, 0, re);
        return re;
    }

    public static void func(int[] num, int index, ArrayList<ArrayList<Integer>> re) {
        if (index == num.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < num.length; i++) {
                tmp.add(num[i]);
            }
            re.add(tmp);
        }
        for (int i = index; i < num.length; i++) {
            if (i != index && num[i] == num[index]) {
                continue;
            }
            change(num, index, i);
            func(num, index + 1, re);
            change(num, index, i);
        }
    }

    public static void change(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
