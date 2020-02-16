package ExperienceOfferTest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class A30_GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int[] input = {5, 4, 3, 2, 1, 7, 8, 95};
        A30_GetLeastNumbers_Solution test = new A30_GetLeastNumbers_Solution();
        ArrayList<Integer> re = test.GetLeastNumbers_Solution1(input, 3);
        System.out.println();
    }
    //利用最大堆
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        if (input == null || input.length == 0 || k < 1 || k > input.length) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.add(input[i]);
            } else {
                if (queue.peek() > input[i]) {
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i:queue
             ) {
            result.add(i);
        }
        Collections.sort(result);
        return result;
    }
    //利用快排
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k < 1 || k > input.length) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = input.length - 1;
        int i = partition(input, left, right);
        while (i != k - 1) {
            if (i > k - 1) {
                right = i - 1;
            } else {
                left = i + 1;
            }
            i = partition(input, left, right);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int j = 0; j < k; j++) {
            result.add(input[j]);
        }
        return result;
    }

    public int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int piriot = array[left];
        while (i < j) {
            while (i < j && array[j] >= piriot) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= piriot) {
                i++;
            }
            array[j] = array[i];
        }
        array[j] = piriot;
        return j;
    }
}
