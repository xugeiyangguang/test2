package Leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNumberOnce {
    public static void main(String[] args) {

    }
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> i:map.entrySet()){
            if(i.getValue()==1){
                return str.indexOf(i.getKey());
            }
        }
        return 0;
    }
}
