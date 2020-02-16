package JDBCProgramme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Anagrams {
    public static void main(String[] args) {
        String[] strs = {"", "od", "", "eat", "den"};
        ArrayList<String> re = anagrams(strs);

        for (String i:re
             ) {
            System.out.println(i);
        }

    }
    public static ArrayList<String> anagrams(String[] strs) {

        HashMap<ArrayList<Character>,ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<strs.length-1;i++){
            ArrayList<Character> tmp = new ArrayList<>();

            for(int j = 0;j<strs[i].length();j++){
                tmp.add(strs[i].charAt(j));
            }
            Collections.sort(tmp);
            if(map.containsKey(tmp)){
                map.get(tmp).add(strs[i]);
            }else{
                ArrayList<String> value = new ArrayList<>();
                value.add(strs[i]);
                map.put(tmp,value);
            }
        }
        ArrayList<String> re = new ArrayList<>();
        for(ArrayList<String> i:map.values()){
            if(i.size()!=1){
                re = i;

            }
        }
        return re;
    }
}
