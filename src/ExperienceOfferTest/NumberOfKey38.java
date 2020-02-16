package ExperienceOfferTest;

import javax.print.attribute.standard.NumberUp;

public class NumberOfKey38 {
    public static void main(String[] args) {
        NumberOfKey38 test = new NumberOfKey38();
        int[] array = {1,3,3,3,3,4,5};
        System.out.println(test.GetNumberOfK(array,2));
    }
    public int GetNumberOfK(int [] array , int k) {
        int low = getLow(array,k,0,array.length-1);
        int high = getHigh(array,k,0,array.length-1);
        return low==-1||high==-1?-1:high-low+1;

    }
    public int getLow(int[] array, int k,int start,int end){
        if (array == null || array.length == 0 ||end<0||start>array.length-1|| end < start){
            return -1;
        }
        int mid = (end+start)>>1;
        if (array[mid] == k ){
            /*if (mid==0){
                return 0;
            }*/
            while (mid>=1&&array[mid-1]==k){
                mid--;
            }
            return mid;
        }else if(array[mid] > k){
            end = mid-1;
            return getLow(array,k,start,end);
        }else{
            start = mid+1;
            return getLow(array,k,start,end);
        }
    }
    public int getHigh(int[] array, int k, int start,int end){
        if (array == null || array.length == 0 ||start<0||end<0||start>array.length-1
                ||end>array.length-1|| end < start){
            return -1;
        }
        int mid = (end+start)>>1;
        if (array[mid] == k ){
            while (mid<array.length-1&&array[mid+1]==k){
                mid++;
            }
            return mid;
        }else if(array[mid] > k){
            end = mid-1;
            return getHigh(array,k,start,end);
        }else{
            start = mid+1;
            return getHigh(array,k,start,end);
        }

    }
}
