package 重要算法;

import java.util.*;

//对hashMap按照value排序
public class 使用value对hashMap排序 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 5);
        map.put(2, 4);
        map.put(3, 3);
        map.put(4, 2);
        map.put(5, 1);


        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> o1.getValue()-o2.getValue());

        Iterator<Map.Entry<Integer, Integer>> iterator = list.iterator();
        System.out.println(list);
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> item = iterator.next();
            System.out.print("key=" + item.getKey());
            System.out.println(",value=" + item.getValue());
        }
    }
}
