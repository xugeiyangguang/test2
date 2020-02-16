package ExperienceOfferTest2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class A65_maxInWindows {
    public static void main(String[] args) {
        A65_maxInWindows test = new A65_maxInWindows();
        int[] num = {2, 3, 4};
        ArrayList<Integer> re = test.maxInWindows(num, 3);
        System.out.println();
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || num.length < size || size < 1) {
            return new ArrayList<>();
        }

        ArrayList<Integer> re = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        int index = 1;
        if (size == 1) {
            re.add(num[deque.getFirst()]);
        }
        while (index < num.length) {
            while (deque.size() > 0 && num[index] >= num[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(index);
            if (index - deque.getFirst() + 1 > size) {
                deque.pollFirst();
            }
            index++;
            if (index >= size) {
                re.add(num[deque.getFirst()]);
            }

        }
        return re;
    }
}
