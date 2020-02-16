package Companies.Pdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
       // Scanner s = new Scanner(System.in);
    //    String str = s.nextLine();
        String[] a = {"abc", "cde", "efa"};
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            // 出度
            char start = a[i].charAt(0);
            if (map.containsKey(start)) {
                ArrayList<Integer> tmp = map.get(start);
                tmp.set(0, tmp.get(0) + 1);
                map.put(start, tmp);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(1);
                tmp.add(0);
                map.put(start, tmp);
            }

            char end = a[i].charAt(a[i].length()-1);
            if (map.containsKey(end)) {
                ArrayList<Integer> tmp = map.get(end);
                tmp.set(1, tmp.get(1) + 1);
                map.put(end, tmp);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(0);
                tmp.add(1);
                map.put(end, tmp);
            }
        }

        for (Character i: map.keySet()
             ) {
            if (map.get(i).get(0) != map.get(i).get(1)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);

    }
}
