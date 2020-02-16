package ExperienceOfferTest;

import java.util.ArrayList;

public class TwoNumberWithSum41_1 {
    public static void main(String[] args) {
        TwoNumberWithSum41_1 test = new TwoNumberWithSum41_1();
        int[] arrays = {1,2,3,4,5,11,13,14,15};
        ArrayList<Integer> r = test.FindNumbersWithSum(arrays,15);
        if (r!=null){
            for (int i:r
                 ) {
                System.out.println(i);
            }
        }
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array == null||array.length==0){
            return new ArrayList<>();
        }
        int start = 0;
        int end = array.length-1;
        int r;
        int minMul=100;
        int i = 0;
        int j = 0;
        while (start<end){
            r = array[start]+array[end];
            if (sum>r){
                start++;
            }
            else if (sum<r){
                end--;
            }else {
                if (array[start]*array[end]<minMul){
                    minMul = array[start]*array[end];
                    i = start;
                    j = end;
                }
                start++;
            }
        }
        if (i==0&&j==0){
            return new ArrayList<>();
        }
        else {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(array[i]);
            result.add(array[j]);
            return result;
        }

    }
}
