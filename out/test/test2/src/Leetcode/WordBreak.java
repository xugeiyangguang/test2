package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("le");
        dict.add("e");
        dict.add("");
        dict.add("code");
        WordBreak test = new WordBreak();
        boolean re = test.wordBreak(s, dict);
        System.out.println();

    }
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i))) {
                if (wordBreak(s.substring(i), dict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
