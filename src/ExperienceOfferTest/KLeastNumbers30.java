package ExperienceOfferTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLeastNumbers30 {
    public static void main(String[] args){
        KLeastNumbers30 test = new KLeastNumbers30();
        int[] input = {4,5,1,6,2,0,3,8};
        int k = 4;
        ArrayList<Integer> result = test.GetLeastNumbers_Solution(input,k);
        if (result != null){
            for (Integer i:result
            ) {
                System.out.print(i);
            }
        }
    }
    /*方法一，基于快排,会改变原来的数组*/
    /*public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k<=0 || k> input.length){
            return new ArrayList<>();
        }
        int left = 0;
        int right = input.length-1;
        int index = SortFunction.Partition1(input,left,right);
        while (index != k-1){
            if(index < k-1){
                left = index+1;
            }
            else {
                right = index-1;
            }
            index = SortFunction.Partition1(input,left,right);
        }
        ArrayList<Integer> result = new ArrayList();
        for (int i=0; i<k; i++){
            result.add(input[i]);
        }
        return result;
    }*/
    /*方法二：适合处理海量的数据，O(nlogk),基于优先队列--堆*/
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k<=0 || k> input.length){
            return new ArrayList<>();
        }
        /*使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。*/
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<input.length; i++){
            if(i<k){
                queue.offer(input[i]);
            }else if(queue.peek()>input[i]){
                Integer temp = queue.poll();
                temp = null;
                queue.offer(input[i]);
            }
        }
        for (Integer i:queue
             ) {
            result.add(i);
        }
        return result;
    }
}
