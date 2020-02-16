package Companies.ToutTiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(s.nextInt());
            tmp.add(s.nextInt());
            list.add(tmp);
        }
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        ArrayList<Integer> time = new ArrayList<>();
        //需要时间
        int he = s.nextInt();
        time.add(s.nextInt());
        time.add(s.nextInt());
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(i).get(0) <= time.get(0)) {
                int x = time.get(0) - list.get(i).get(0);
                x = x * 60;
                int y = time.get(1) - list.get(i).get(1);
                y += x;
                if (y >= he) {
                    System.out.print(list.get(i).get(0));
               //     System.out.print();
                    System.out.print(list.get(i).get(1));
                    return;
                }
            }
        }
    }
}
