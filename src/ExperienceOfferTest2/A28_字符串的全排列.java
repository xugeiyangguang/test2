package ExperienceOfferTest2;

import java.util.ArrayList;
import java.util.Collections;

public class A28_字符串的全排列 {
    public static void main(String[] args) {
        A28_字符串的全排列 test = new A28_字符串的全排列();
        test.Permutation("aa");
        System.out.println();
    }
    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str == null) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        PermutationCore(chars, 0);
        Collections.sort(result);
        return result;
    }

    public void PermutationCore(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            String str = new String(chars);
            if (!result.contains(str)) {
                result.add(str);
            }
        }
        for (int i = begin; i < chars.length; i++) {
            exchange(chars, begin, i);
            PermutationCore(chars, begin + 1);
            exchange(chars, begin, i);
        }
    }

    public void exchange(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }
}
