package 测试;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Two {
    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        func(a, 4);
    }

    public static void func(int[] a, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer) ;
            }
        });
        for (int i = 0; i < a.length; i++) {
            priorityQueue.offer(a[i]);


        }
        for (int i = 0; i < a.length; i++) {
            if (priorityQueue.contains(a[i])) {
                System.out.print(a[i]);
            }
        }
    }

}
