package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class A19findLadders {
    public static void main(String[] args) {
        A19findLadders test = new A19findLadders();
        String start = "hit";
        String end =  "cog";
        HashSet<String> dic = new HashSet<>();
        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");
        test.findLadders(start,end,dic);
        System.out.println();
    }
    public static ArrayList<ArrayList<String>> re = new ArrayList<>();
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0 || start == null || end == null){
            return new ArrayList<>();
        }
        ArrayList<String> s = new ArrayList<>();
        findLaddersCore(start, end, dict, s);
        return re;
    }
    public void findLaddersCore(String start, String end, HashSet<String> dict, ArrayList<String> s ){
        if (start.equals(end)){
            re.add(s);
            return;
        }
        s.add(start);
        //用集合来存储只变一位的串
        HashSet<String> common = new HashSet<>();
        for (int i = 0; i < start.length(); i++){
         //   int firstDifferntIndex = findFristDifferent(start.substring(i),end);
            while (start.charAt(i) == end.charAt(i)){
                i++;
            }
            common = commonSubstr(start, dict, i, s, common);
            if (common.size() != 0){
                break;
            }
        }

        for (String j: common
             ) {
            //将前面部分复制到新的List中
            ArrayList<String> s1 = new ArrayList<>();
            for (String i: s
                 ) {
                s1.add(i);
            }
            //s1.add(j);
            findLaddersCore(j, end, dict, s1);
        }

    }
    //返回两个字符串第一个不相同位置的下标
    public int findFristDifferent(String s1, String s2){
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return i;
            }
        }
        //没有相同的字符
        return -1;
    }
    //查找只有指定位不同的字符串
    public HashSet<String> commonSubstr(String start, HashSet<String> dict,
                                        int pos, ArrayList<String> str,
                                        HashSet<String> common){
        HashSet<String> comonSub = new HashSet<>();
        for (String s : dict
        ) {
            String x = start.substring(0,pos)+start.substring(pos+1);
            String y = s.substring(0,pos)+s.substring(pos+1);
            if (s != start && x.equals(y) && !str.contains(s)&&!common.contains(s)){
                comonSub.add(s);
            }
        }
        return comonSub;
    }
}
