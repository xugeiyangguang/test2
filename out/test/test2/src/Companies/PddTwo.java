package Companies;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class PddTwo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] str = s.nextLine().split(" ");
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(Integer.valueOf(str[0]));
            tmp.add(Integer.valueOf(str[1]));
            lists.add(tmp);
        }

        ArrayList<ArrayList<Integer>> lists1 = new ArrayList<>();
        int re = 0;
        lists1.add(lists.get(0));
        re += lists.get(0).get(1) - lists.get(0).get(0)+1;
        System.out.println(re);
        for (int i = 1; i < lists.size(); i++) {
            ArrayList<Integer> tmp1 = lists.get(i);
            int flag = 0;//没有重合
            for (int j = 0; j < lists1.size(); j++) {
                if (lists1.get(j).get(0) <= tmp1.get(0) && lists1.get(j).get(1) >= tmp1.get(0) ||
                        lists1.get(j).get(0) <= tmp1.get(1) && lists1.get(j).get(1) >= tmp1.get(1)) {
                    flag = 1;
                 //   ArrayList<Integer> t1 = lists1.remove(j);
                    ArrayList<Integer> tmp = lists1.remove(j);
                    re -= tmp.get(1) - tmp.get(0)+1;
                    ArrayList<Integer> tt = new ArrayList<>();
                    tt.add(Math.min(tmp.get(0), tmp1.get(0)));
                    tt.add(Math.max(tmp.get(1), tmp1.get(1)));
                    lists1.add(tt);
                    re += tt.get(1) - tt.get(0)+1;
                    System.out.println(re);
                    break;
                }
            }
            if (flag == 0) {
                lists1.add(tmp1);
                re += tmp1.get(1) - tmp1.get(0) + 1;
                System.out.println(re);
            }
        }
    }
}
