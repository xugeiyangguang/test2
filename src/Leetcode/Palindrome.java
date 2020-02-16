package Leetcode;

public class Palindrome {
    public static void main(String[] args) {
        String s = "a.";
        boolean re = isPalindrome(s);
        System.out.println();
    }
    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuffer ss = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                ss.append(str.charAt(i));
            }
        }
        String str1 = ss.toString();
        if(str1.length()==1){
            return true;
        }
        for(int i=0;i<str1.length()/2;i++){
            if(str1.charAt(i)!=str1.charAt(str1.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
