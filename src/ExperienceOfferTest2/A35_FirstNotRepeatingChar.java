package ExperienceOfferTest2;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class A35_FirstNotRepeatingChar {
    public static void main(String[] args) {
        A35_FirstNotRepeatingChar test = new A35_FirstNotRepeatingChar();
        int re = test.FirstNotRepeatingChar("google");
        System.out.println();
    }
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
            } else {
                hashMap.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }
}
