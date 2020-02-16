package Companies.JingDong;

import java.util.*;

public class Three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 2 * n; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int p = s.nextInt();
            int q = s.nextInt();
            tmp.add(p);
            tmp.add(q);
            relation.add(tmp);
            map.put(p, map.get(p) + 1);
            map.put(q, map.get(q) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> table = new ArrayList<>(map.entrySet());

        int count = 0;
        ArrayList<Integer> re = new ArrayList<>();
     //   Collections.sort(table, (o1, o2) -> o2.getValue()-o1.getValue());
        Collections.sort(table, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        while (table.get(0).getValue() != 0) {

            int people = table.get(0).getKey();
            for (ArrayList<Integer> i : relation) {
                if (i.contains(people)) {
                    int index = i.indexOf(people);
                    int tmp_key;
                    if (index == 1) {
                        tmp_key = i.get(0);
                    } else {
                        tmp_key = i.get(1);
                    }
                    map.put(tmp_key, map.get(tmp_key) - 1);

                }
            }
            map.put(people, 0);
            re.add(people);
            count++;
            Collections.sort(table, (o1, o2) -> o2.getValue()-o1.getValue());
        }
        System.out.println(count);
        Collections.sort(re);
        for (Integer i : re) {
            System.out.print(i+" ");
        }
    }
}
