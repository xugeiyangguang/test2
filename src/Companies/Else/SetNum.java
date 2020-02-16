package Companies.Else;

import java.util.*;

public class SetNum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> lists = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;   //记录集合最大的长度
        for (int i = 0; i < n; i++) {
            int key = s.nextInt();
            int value = s.nextInt();
            if (map.containsKey(key)) {
                if (value > map.get(key)) {
                    map.put(key, value);
                }
            } else {
                lists.add(key);
                map.put(key, value);
            }
            len = Math.max(len, value);
        }
        Collections.sort(lists);
        int count = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (map.get(i) != len) {

            }
        }

    }
}
