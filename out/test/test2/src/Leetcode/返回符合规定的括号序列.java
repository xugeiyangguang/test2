package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 返回符合规定的括号序列 {
    public static void main(String[] args) {
        ArrayList<String> re = generateParenthesis(3);
        System.out.println(re);
    }
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> re = new ArrayList<>();
        func(re,n,n,n,"");
        return re;
    }
    public static void func(ArrayList<String> re,int left,int right,int n,String s){
        if(right==0){
            re.add(s);
            return;
        }
        if(left!=0){
            func(re,left-1,right,n,s+"(");
        }
        if(left<=right){
            func(re,left,right-1,n,s+")");
        }
    }
}
