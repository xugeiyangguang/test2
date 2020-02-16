/*
package ExperienceOfferTest;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortArrayForMinNumber33 {
    public static void main(String[] args){
        SortArrayForMinNumber33 test = new SortArrayForMinNumber33();
        int[] numbers = {3,32,321};

        System.out.println(test.PrintMinNumber(numbers));

    }
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return new String();
        }
        String[] strNum = new String[numbers.length];
        for (int i = 0; i<numbers.length; i++){
            strNum[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNum, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                String one = o1 + o2;
                String two = o2 + o1;
                return one.compareTo(two);
            }
        });
        */
/*String result = "";
        for (String i:strNum
             ) {
            result+=i;   //String和StringBuffer增加元素不一样
        }*//*

        StringBuffer r = new StringBuffer();
        for (String i:strNum
             ) {
            r.append(i);
        }
        r.toString();
        return r.toString();
    }
}
*/
