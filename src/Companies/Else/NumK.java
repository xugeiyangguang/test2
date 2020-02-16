package Companies.Else;

import java.util.*;
public class NumK{
    public static void main(String[] args){
        int[] a  = {5,4,3,2,1};
        int index = partition(a,0,a.length-1);
        int k = 3;
        int start = 0;
        int end = a.length-1;
        while(index!=k-1){
            if(index<k-1){
                start = index+1;

            }else{
                end = index-1;

            }
            index=partition(a,start,end);
        }
        System.out.println(a[index]);

    }
    public static int partition(int[] a,int start,int end){
        int key = a[start];
        int i=start;
        int j = end;
        while(i<j){
            while(i<j&&a[j]>=key){
                j--;

            }
            a[i] = a[j];
            while(i<j&&a[i]<=key){
                i++;
            }
            a[j]=a[i];
        }
        a[i]=key;
        return i;
    }
}
