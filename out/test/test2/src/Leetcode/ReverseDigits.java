package Leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseDigits {
    public static void main(String[] args) {
        int x = 0;
        ArrayList<Character> list = new ArrayList<>();
        int flag = x >= 0?0:-1;
        int num = x>0?x:-x;
        String s = String.valueOf(num);
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        Collections.reverse(list);
        while(list.get(0)=='0'){
            list.remove(0);
        }
        StringBuffer re = new StringBuffer();
        for(Character i:list){
            re.append(i);
        }
        int r = Integer.valueOf(re.toString());
        if (flag == -1) {
            System.out.println(r * flag);
        }else{
            System.out.println(r);
        }

    }

}
