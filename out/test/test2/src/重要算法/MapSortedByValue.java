package 重要算法;

import java.util.*;

public class MapSortedByValue {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 1);
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> i:map.entrySet()
             ) {
            list.add(i);
        }
        Collections.sort(list,(o1,o2)->o1.getValue() - o2.getValue());
        System.out.println();
    }
}
