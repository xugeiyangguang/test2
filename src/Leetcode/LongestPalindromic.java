package Leetcode;

public class LongestPalindromic {
    public static void main(String[] args) {
        String s = "baaaab";
        String re = longestPalindrome(s);
        System.out.println(re);

    }
    public static String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return null;
        }
        int max = 1;
        int maxStart = 0;
        int maxEnd = 0;
        int count = 1;
        int start = 0;
        int end = 0;
        for(int i =0;i<s.length();i++){
            if (i-1>=0&&i+1<s.length()&&s.charAt(i-1)==s.charAt(i+1)){
                count = 1;
                start = i - 1;
                end = i + 1;
                while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
                    count+=2;
                    if(count>max){
                        max = count;
                        maxStart = start;
                        maxEnd = end;
                    }
                    start--;
                    end++;
                }
            }
            if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
                count = 0;
                start = i;
                end = i + 1;
                while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
                    count+=2;
                    if(count>max){
                        max = count;
                        maxStart = start;
                        maxEnd = end;
                    }
                    start--;
                    end++;
                }
            }

        }
        return s.substring(maxStart,maxEnd+1);
    }
}
