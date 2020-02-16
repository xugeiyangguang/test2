package Companies.Baidu;

import java.util.*;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = s.nextInt();
            int v = s.nextInt();
            map.put(k, v);
            for (int j = 0; j < v; j++) {
                list.add(k);
            }
        }
        Collections.sort(list);
        int count = 0;
        while (list.size() - 1 > 0 && list.get(list.size() - 1) >= m) {
            count++;
            list.remove(list.size() - 1);
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < list.size() && right >= 0 && left < right) {
            if (list.get(left) + list.get(right) >= m) {
                count++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        System.out.println(count);
    }
}
