package ExperienceOfferTest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedianHeap {
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public static void main(String[] args) {
        StreamMedianHeap test = new StreamMedianHeap();
        test.Insert(5);
        test.Insert(2);
        test.Insert(3);
        test.Insert(4);
        test.Insert(1);
        test.Insert(6);
        test.Insert(7);
        test.Insert(0);
        test.Insert(8);
        System.out.println(test.GetMedian());
        System.out.println();

    }

    public void Insert(Integer num) {
        if ((max.size() + min.size()) %2==0){   //如果当前的节点总数目是偶数,放入最小堆中
            if (max.size() > 0 && num < max.peek()){  //如果num<最大堆的堆顶值
                //int temp = max.poll();   //将最大堆的堆顶取出来
               // min.add(num);    //放入最小堆中
                max.add(num);   //将num加入最大堆中
                min.add(max.poll());
            }else {
                min.add(num);
            }

        }else {
            if (min.size() > 0 && num > min.peek()){
                //int temp = min.poll();
              //  max.add(temp);
                min.add(num);
                max.add(min.poll());
            }else {
                max.add(num);
            }

        }
    }
    public Double GetMedian() {
        int size = max.size() + min.size();
        if (size == 0){
            return null;
        }
        if (size%2 == 0){
            return (double)(min.peek()+max.peek())/2;
        }
        return (double)min.peek();
    }
}
