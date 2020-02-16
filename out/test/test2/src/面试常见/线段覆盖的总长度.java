package 面试常见;

import java.util.ArrayList;
import java.util.Collections;

public class 线段覆盖的总长度 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        list.add(a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        list.add(b);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(0);
        c.add(2);
        list.add(c);
        ArrayList<Integer> d = new ArrayList<>();
        d.add(3);
        d.add(4);
        list.add(d);
        ArrayList<Integer> e = new ArrayList<>();
        e.add(7);
        e.add(8);
        list.add(e);
        int re = func(list);
        System.out.println(re);
    }

    public static int func(ArrayList<ArrayList<Integer>> list) {
        int re = 0;
        Collections.sort(list, (o1, o2) -> o1.get(0) - o2.get(0));
        int start = 0;
        int end = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0) == start) {
                end = list.get(i).get(1);
            } else {
                re += end - start;
                start = list.get(i).get(0);
                end = list.get(i).get(1);
            }
        }
        re += end - start;
        return re;
    }
}
