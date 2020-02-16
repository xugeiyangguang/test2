package Leetcode;

public class IsScramble {
    public static void main(String[] args) {
        IsScramble test = new IsScramble();
        boolean re = test.isScramble("great","rtgae");
        System.out.println();

    }
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        //检查两个字符串的字母是否相同的
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i:count
             ) {
            if (i != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
