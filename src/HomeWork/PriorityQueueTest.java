package HomeWork;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);

        while (queue.size() != 0) {
            System.out.print(queue.poll());
        }
    }
}
