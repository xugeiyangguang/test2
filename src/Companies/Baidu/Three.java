package Companies.Baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (map.containsKey(a)) {
                ArrayList<Integer> tmp = map.get(a);
                tmp.add(b);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(b);
                map.put(a, tmp);
            }
        }
        int step = 1;
        int[] re = new int[n];
        while (map.size() != 0) {
            for (Integer i : map.keySet()) {
                ArrayList<Integer> queue = new ArrayList<>();
                if (map.get(i).size() == 0 || map.get(i).size() == 1) {
                    re[i] = step;
                    queue.add(i);
                    map.remove(i);
                }
                if (queue.size() != 0) {
                    for (ArrayList<Integer> j : map.values()) {
                        for (Integer k : queue) {
                            if (j.contains(k)) {
                                j.remove(k);
                            }
                        }
                    }
                }

            }

        }
        for (int i : re) {
            System.out.print(i + " ");
        }
    }
}
