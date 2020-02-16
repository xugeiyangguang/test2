package Companies.Else;

import java.util.HashSet;
import java.util.Scanner;
public class ColorStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<Character> re = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            re.add(s.charAt(i));
        }
        if (re.size() > 2) {
            System.out.println(0);
        }
        else{
            System.out.println(re.size());
        }
    }
}
