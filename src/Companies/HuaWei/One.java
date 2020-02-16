package Companies.HuaWei;

import java.util.ArrayList;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < str.length; i++) {
            if (str[i].equals("A")) {
                list.add("12");
                list.add("34");
            } else if (str[i].equals("B")) {
                list.add("AB");
                list.add("CD");
            } else {
                list.add(str[i]);
            }
        }
        String one = Integer.toHexString(list.size()+1).toUpperCase();
        for (String i : list) {
            one += " " + i;
        }
        System.out.println(one);

    }
}
