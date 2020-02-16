package Leetcode;

public class longestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int re = lengthOfLongestSubstring(s);
        System.out.println();
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int left = 0;
        int right = 1;
        int max = 0;
        while (right < s.length()) {
            for (int i = left; i < right; i++) {
                if (s.charAt(i) == s.charAt(right)) {
                    left = i + 1;
                    break;
                }
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
