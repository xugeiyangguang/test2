package Leetcode;

public class MinDistance {
    public static void main(String[] args) {
        int re = new MinDistance().minDistance("sea", "eat");
        System.out.println();
    }
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        StringBuffer s1 = new StringBuffer(word1);
        StringBuffer s2 = new StringBuffer(word2);
        return minDistanceCore(s1, s2,0);
    }

    public int minDistanceCore(StringBuffer s1, StringBuffer s2, int index) {
        while (index < s1.length() && index < s2.length()&&s1.charAt(index) == s2.charAt(index) ) {
            index++;
        }
        if (index == s1.length() && s1.length() == s2.length()) {
            return 0;
        } else {
            int step = 0;
            int deleteStep = 0;
            int addStep = 0;
            int replaceStep ;
            if (s1.length() > s2.length()) {
                s1.deleteCharAt(index);
                deleteStep = minDistanceCore(s1, s2, index);
            } else if (s1.length() < s2.length()) {
                s1.insert(index, s2.charAt(index));
                addStep = minDistanceCore(s1, s2, index);
            } else {
                s1.setCharAt(index, s2.charAt(index));
                replaceStep = minDistanceCore(s1, s2, index);
            }
            return step + 1;
        }
    }
}
