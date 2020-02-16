package Leetcode;

import java.util.*;

public class 将字符串分割为词组 {
    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        wordBreak(s, dict);
        Collections.sort(re);
        Collections.reverse(re);
        System.out.println(re);
    }
    private static ArrayList<String> re = new ArrayList<>();
    public  static ArrayList<String> wordBreak(String s, Set<String> dict) {

        StringBuffer str = new StringBuffer("");
        func(str,dict,s);
        Collections.sort(re);
        Collections.reverse(re);
        //   System.out.println(re);
        return re;
    }
    public static void func(StringBuffer str,Set<String> dict,String s){
        if(s==null||s.length()==0){
            str.deleteCharAt(str.length()-1);
            re.add(str.toString());
            return;
        }
        for(int j=0;j<=s.length();j++){
            if(dict.contains(s.substring(0,j))){
                String tmp = s.substring(0, j);
                //     dict.remove(s.substring(0,j));
                int len = str.length();
                str.append(tmp);
                str.append(" ");
                func(str,dict,s.substring(j));
                if (len - 1 < 0) {
                    str.delete(len, str.length());
                } else {
                    str.delete(len,str.length());
                }

                //       dict.add(tmp);
            }
        }
    }
}
