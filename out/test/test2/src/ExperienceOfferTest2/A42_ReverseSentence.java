package ExperienceOfferTest2;

import java.util.ArrayList;
import java.util.List;

public class A42_ReverseSentence {
    public static void main(String[] args) {
        A42_ReverseSentence test = new A42_ReverseSentence();
        String re = test.ReverseSentence("I am a student.");
        System.out.println();
    }
    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        int start;
        int end;
        for (int i = 0; i < str.length();) {
            if (str.charAt(i) != ' ') {
                start = i;
                while (i < str.length() && str.charAt(i) != ' ') {
                    i++;
                }
                end = i - 1;
                ReverseSingleWord(chars, start, end);
            } else {
                i++;
            }
        }
        ReverseSingleWord(chars, 0, str.length() - 1);
        return String.valueOf(chars);
    }

    public void ReverseSingleWord(char[] chars,int start,int end) {
        for (int i = start; i <= (end + start) / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[end - i + start];
            chars[end - i + start] = temp;
        }
    }
}
