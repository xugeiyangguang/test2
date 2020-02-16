package Companies.Kuaishou;

import java.util.ArrayList;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] s1 = s.nextLine().split(" ");
        String[] s2 = s.nextLine().split(" ");
        int c1 = 0;
        int c2 = 0;
        ArrayList<String> list = new ArrayList<>();
        while (c1 < s1.length && c2 < s2.length) {
            for (int i = 0; i < 4 && c1 < s1.length; i++) {
                list.add(s1[c1++]);
            }
            list.add(s2[c2++]);
        }
        while (c1 != s1.length) {
            list.add(s1[c1++]);
        }
        while (c2 != s2.length) {
            list.add(s2[c2++]);
        }
        for (String i : list) {
            System.out.print(i+" ");
        }
    }
}
