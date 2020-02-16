package Leetcode;

public class A20isPalindrome {
    public static void main(String[] args) {
        A20isPalindrome test = new A20isPalindrome();
        boolean re = test.isPalindrome2("`l;`` 1o1 ??;l`");
        System.out.println();

    }
    //方法一：跳过费字符数字
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        int start = 0;
        int end = s.length() -1;
        while (start < end){
            while (!isWord(s.charAt(start)) && start < end){
                start++;
            }
            while (!isWord(s.charAt(end)) && start < end){
                end --;
            }
            if (s.charAt(start) == s.charAt(end) ||
                    s.charAt(start) - 32 == s.charAt(end) ||
                    s.charAt(start) + 32 == s.charAt(end)){
                start ++;
                end --;
            }else {
                return false;
            }
        }
        return true;
    }
    public boolean isWord(char a){
        if ('a' <= a && a <= 'z' || 'A' <= a && a <= 'Z' || Character.isDigit(a)){
            return true;
        }
        return false;
    }

    //方法二：将费方法数字删除
    public boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String str = s.replaceAll("\\W","");
        for (int start = 0, end = str.length()-1; start < end; start ++,end -- ){
            if (str.charAt(start) == str.charAt(end) ||
                    str.charAt(start) - 32 == str.charAt(end) ||
                    str.charAt(start) + 32 == str.charAt(end)){

            }else {
                return false;
            }
        }
        return true;
    }
}
