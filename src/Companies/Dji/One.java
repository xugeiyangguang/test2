package Companies.Dji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for (int i = 0; i < num; i++) {
            int n = s.nextInt();
            int x = s.nextInt();
            int val[] = new int[n];
            int time[] = new int[n];
            for (int j = 0; j < n; j++) {
                val[j] = s.nextInt();
                time[j] = s.nextInt();
            }
            int max = 0;
            //将其他行初始化为0
            int a[][] = new int[n + 1][x + 1];
            //n = value
            for (int p = 1; p <= n; p++) {
                //x = time
                for (int q = 1; q <= x; q++) {
                    int tmp = q >= time[p - 1] ? a[p-1][q - time[p - 1]] + val[p - 1] : 0;
                    // int tmp = q >= time[p - 1] ? a[p][q - time[p - 1]] + val[p - 1] : 0;
                    a[p][q] = Math.max(a[p - 1][q], tmp);
                    if (a[p][q] > max) {
                        max = a[p][q];
                    }
                }

            }
            System.out.println(a[n][x]);
            /*ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(s.nextInt());
                tmp.add(s.nextInt());
                list.add(tmp);
            }
            Collections.sort(list,((o1, o2) -> o2.get(1)-o1.get(1)));
            ArrayList<Integer> re = new ArrayList<>();
            func(list, 0, x, re);
            Collections.sort(re);
            System.out.println(re.get(re.size() - 1));*/
        }
    }

    public static void func(ArrayList<ArrayList<Integer>> list, int count, int time, ArrayList<Integer> re) {

        if (list.size() == 0||time < list.get(0).get(1)) {
            re.add(count);
            return;
        }
        ArrayList<Integer> t = list.get(0);
        list.remove(0);
        //挑选第一个
        func(list, count + t.get(0), time - t.get(1), re);

        //不挑选
        func(list, count, time, re);
        list.add(t);

    }
}
