package Companies.HuaWei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        String one = s.nextLine();
        set.add(one);
        int m = s.nextInt();
        s.nextLine();
        for (int i = 0; i < m; i++) {
            String tmp = s.nextLine();
            String[] t = tmp.split(",");
            HashSet<String> k = new HashSet<>();
            for (int q = 0; q < t.length; q++) {
                k.add(t[q]);
            }
            for (String p : set) {
                if (k.contains(p)) {
                    for (int j = 0; j < t.length; j++) {
                        if (!set.contains(t[j])) {
                            set.add(t[j]);
                        }
                    }
                    break;
                }
            }

        }
        System.out.println(set.size());
    }
}
