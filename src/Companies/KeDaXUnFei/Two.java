package Companies.KeDaXUnFei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
     //   Scanner s = new Scanner(System.in);
     //   String str = s.nextLine();
        String str = "爱讯飞789swr1wwen34ifly65tek";

    }

    public static void func(String str) {
        if (str == null) {
            return;
        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                list.add(str.charAt(i));
            }
        }
        Collections.sort(list);
        if (list.size() == 0) {
            System.out.println(-1);

        } else {
            for (Character i:list
            ) {
                System.out.print(i);
            }
        }

    }

}

