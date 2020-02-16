package ExperienceOfferTest;

import java.util.Random;

/**两种快速排序的方法：（用递归实现的快排）
  时间复杂度：O（n*lgn）
  最坏：O（n^2）
  空间复杂度：O（n*lgn）
  不稳定。**/
public class SortFunction {
    /*每一遍的排序*/
    /*版本一:以第一个元素为主元*/
    /*1.先从后面找到比它小的，交换
    2.从前面找到比它大的，交换
    3.直到high<low*/
    public static int Partition1(int[] arr,int low,int high){
        if(arr==null || arr.length==0 || low < 0 || high >= arr.length){
            System.out.println("input is illega！");
        }
        int key = arr[low];
        while(high > low){
            /*里面循环的时候也要加上 high > low，不然有序的时候会越界*/
            while(arr[high] >= key && high > low){
                high--;
            }
            arr[low] = arr[high];
            while (arr[low] <= key && high > low){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[high] = key;
        return high;
    }

    /*版本二:以最后一个元素为主元*/
    /**/
    public static int Partition2(int[] arr,int low,int high){
        if(arr==null || arr.length==0 || low < 0 || high >= arr.length){
            System.out.println("inputvv   is illega！");
        }
        int small = low - 1;
        for (int index = low; index < high; index++ ){
            if(arr[index] < arr[high]){
                small++;
                if(small != index){
                    swap(arr,small,index);
                }
            }

        }

        small++;
        System.out.println("---"+small);
        /*由于这里采用的是另外一种交换值的方法，所以，有相等的限制*/
        if(small != high) {
            swap(arr, small, high);
        }

        return small;   /*返回的是被固定的数的下标位置*/
    }
    public static void swap(int[] arr,int a ,int b){
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }


    /*通过递归，多次排序*/
    public static void QuickSort(int[] arr,int low,int high){
        if (low > high){
            return;
        }
        int index = Partition2(arr,low,high);
        for(int i:arr){
            System.out.print(i+",");
        }
        System.out.println();
        /*if (index >low) {
            各种方法快排(arr, low, index - 1);
        }
        if (index <high) {
            各种方法快排(arr,index+1,high);
        }*/
        QuickSort(arr, low, index - 1);
        QuickSort(arr,index+1,high);
    }
    public static void main(String[] args){
        /*int[] arr = {9,9,3,12,1,8,3,4,65,22};*/
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println("每一趟的结果是：");
        QuickSort(arr, 0, arr.length-1);
        System.out.println("最终结果是：");
        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
