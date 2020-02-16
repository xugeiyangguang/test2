package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;

public class MinK {
    public static void main(String[] args) {
        MinK test = new MinK();
        ArrayList<Integer> re = new ArrayList<>();
        int[] input = {4,1,5,6,2,7,3,8};
        re = test.GetLeastNumbers_Solution(input, 8);
        System.out.println();
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length){
            return new ArrayList<>();
        }
        int n = partition(input,0,input.length-1);
        int start = 0;
        int end = input.length-1;
        while(n!=k-1){
            if(n<k-1){
                n = partition(input,n+1,end);
            }else if(n>k-1){
                n = partition(input,start,n-1);
            }

        }
        ArrayList<Integer> re = new ArrayList<>();
        for(int i=0;i<k;i++){
            re.add(input[i]);
        }
        Collections.sort(re);
        return re;
    }
    public int partition(int[] a,int start,int end){
        int key = a[start];
        int i = start;
        int j = end;
        while(i<j){
            while(i<j&&a[j]>=key){
                j--;
            }
            a[i] = a[j];
            while(i<j&&a[i]<=key){
                i++;
            }
            a[j] = a[i];
        }
        a[i] = key;
        return i;
    }
}
