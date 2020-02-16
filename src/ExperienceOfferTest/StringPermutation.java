package ExperienceOfferTest;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutation {
    public static void main(String[] args){
        String str = "abc";
        ArrayList<String> r = Permutation(str);
        if(r!=null){
            for (String i:r
            ) {
                System.out.println(i);
            }
        }

    }
    public static ArrayList<String> Permutation(String str) {
        if(str == null || str.length()==0){
            return null;
        }
        char[] a = str.toCharArray();
        ArrayList<String> r = new ArrayList<>();
        PermutationChar(a,0,r);
        Collections.sort(r);  /*最后要按照字典顺序打印*/
        return r;
    }
    public static ArrayList<String> PermutationChar(char[] a,int begin,ArrayList<String> r){
        for(int i = begin; i<a.length;i++){
            swap(a,begin,i);
            PermutationChar(a,begin+1,r);
            swap(a,begin,i);
            String s = String.valueOf(a);   //将字符（其他类型不可以）数组转化为字符串，
            if(!r.contains(s)) {
                r.add(s);
            }
        }
        return r;
    }
    public static void swap(char[] a,int i,int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
