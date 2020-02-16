package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinNumbers {
    public static void main(String[] args) {

    }
    public String PrintMinNumber(int [] numbers) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i:numbers
             ) {
            list.add(i);
        }
        Collections.sort(list,(o1, o2)->{
            String s1 = String.valueOf(o1)+String.valueOf(o2);
            String s2 = String.valueOf(o2)+String.valueOf(o1);
            return s1.compareTo(s2);
        });
        StringBuffer re = new StringBuffer();
        for(int i:list){
            re.append(i);
        }
        return re.toString();
    }
}
