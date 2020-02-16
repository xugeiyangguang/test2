package ExperienceOfferTest2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A64_GetMedian {
    public static void main(String[] args) {
        A64_GetMedian test = new A64_GetMedian();
        test.Insert(5);
        double re = test.GetMedian();
        test.Insert(2);
        double re1 = test.GetMedian();
        test.Insert(3);
        double re2 = test.GetMedian();
        test.Insert(4);
        double re3 = test.GetMedian();
        test.Insert(1);
        double re4 = test.GetMedian();
        test.Insert(6);
        double re5 = test.GetMedian();
        test.Insert(7);
        double re6 = test.GetMedian();
        test.Insert(0);
        double re7 = test.GetMedian();
        test.Insert(8);
        double re8 = test.GetMedian();
        System.out.println();
    }
    PriorityQueue<Integer> max = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public void Insert(Integer num) {
        if ((max.size() + min.size()) %2==0){
            if (min.size() > 0 && num > min.peek()) {
                min.add(num);
                max.add(min.poll());
            } else {
                max.add(num);
            }
        } else {
            if (max.size() > 0 && num < max.peek()) {
                max.add(num);
                min.add(max.poll());
            } else {
                min.add(num);
            }
        }
    }

    public Double GetMedian() {
        if (max.size() + min.size() == 0) {
            return 0.0;
        }
        if (((max.size() + min.size()) & 1) == 0) {
            return (double) (max.peek() + min.peek()) / 2;
        } else {
            return (double) max.peek();
        }
    }

}
