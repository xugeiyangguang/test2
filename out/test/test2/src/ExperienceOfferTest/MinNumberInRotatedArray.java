package ExperienceOfferTest;

import java.util.ArrayList;
public class MinNumberInRotatedArray {
    public static void main(String[] args){
       /* int[] array = {3,4,5,1,2};*/
       /* int[] array = {1,1,1,0,1};*/
        int[] array = {};
        int min = minNumberInRotateArray(array);
        System.out.println(min);
    }
    public static int minNumberInRotateArray(int [] array) {
        /*s数组为空或者数组长度为零*/
        if(array==null||array.length==0){
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        int mid = array[0];

        /*一定是旋转过后的旋转数组*/
        while(array[left]>=array[right]){
            if(right-left==1){  /*前后指针相邻，后面指针为最小值*/
                mid = array[right];
                break;
            }
            mid = (right + left)/2;
            if(array[left]==array[right]&&array[right]==array[mid]){
                mid = FindMinInOrder(array);
                break;
            }
            if(array[left]<=array[mid]){
                left = mid;
            }
            else if(array[right]>array[mid]){
                right = mid;
            }
        }
        return mid;
    }
    public static int FindMinInOrder(int[] array){
        int min = array[0];
        for(int i=0; i<array.length; i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
}
