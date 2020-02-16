package ExperienceOfferTest;

import java.util.HashMap;

public class FristNotRepeatingChar {
    public static void main(String[] args){
        FristNotRepeatingChar test = new FristNotRepeatingChar();
        System.out.println(test.FirstNotRepeatingChar("google"));
    }
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        /*数组的下标为其对应的ASCLL值，采用'z'-'使用value对hashMap排序'+1大小使得数组大小更小，更加节约空间*/
        char[] store = new char['z'-'A'+1];
        for (int i=0; i<str.length();i++){
            store[str.charAt(i)-'A'+1]++;
          /*  System.out.println(str.charAt(i));*/
        }
        for (int i = 0;i<str.length();i++){
            /*System.out.println(store[str.charAt(i)]);*/
            if (store[str.charAt(i)-'A'+1]==1){
                return i;
            }
        }
        return -1;
    }
    /*public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        *//*键为字符，值为出现的次数*//*
        *//*hashMap中也能对键和值的类型做限制，在泛型中，Object对象都可以对其进行限制*//*
        HashMap<Character,Integer> store = new HashMap();
        *//*第一遍遍历，需要将字符串的所有字符都加入hashMap中*//*
        for (int i=0; i<str.length(); i++){
            if (store.containsKey(str.charAt(i))){
                int time = store.get(str.charAt(i));
                store.put(str.charAt(i),++time);
            }else {
                store.put(str.charAt(i),1);
            }
        }
        *//*第二遍，找出出现次数为1的*//*
        for (int i=0;i<str.length();i++){
            if (store.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }*/
}
