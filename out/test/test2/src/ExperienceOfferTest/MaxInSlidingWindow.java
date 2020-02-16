package ExperienceOfferTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MaxInSlidingWindow {
    public static void main(String[] args) {
        MaxInSlidingWindow test = new MaxInSlidingWindow();
        int[] num ={2,3,4,2,6,2,5,1};
        ArrayList<Integer> re= test.maxInWindows(num,1);
        System.out.println();
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num == null||num.length==0||num.length<size||size<=0){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();


        ArrayDeque<Integer> queue= new ArrayDeque();
        int i = 0;
        int firstIndex = -1;   //记录队列第一个元素在数组中的下标
        queue.add(num[0]);
        while (i!=num.length){
            while (queue.size()!=0&&queue.getFirst()<num[i]){   //从前面删除元素，
                queue.removeFirst();
                firstIndex++;    //前面删除的话，最大值下标要增加
            }
            while (queue.size()!=0&&queue.getLast()<num[i]){   //从后面删除元素，最大值的下标不用增加
                queue.removeLast();
            }
            queue.offer(num[i]);
            if (queue.size()>size||i - firstIndex >=size){    //将过期的最大值弹出
                queue.removeFirst();
            }
            if (i>=size-1){
                result.add(queue.getFirst());    //存储最大值
            }
            i++;
        }
        return result;
    }
}
