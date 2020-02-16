package ExperienceOfferTest;

import java.util.Arrays;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        char[] arr = {'1','2','3','4','5','6'};

        System.out.println(arr.toString());
        char a = 'a';
        String b = 3.4                      +"";
        System.out.println(b);
    }
    public static char[] Reverse(char[] arr,int start,int end){
        char temp;
        int count = 0;
        for (int i = start;i<(end+start)/2;i++){
            temp = arr[i];
            arr[i] = arr[end-count];
            arr[end-count] = temp;
            count++;
        }
        return arr;
    }
}