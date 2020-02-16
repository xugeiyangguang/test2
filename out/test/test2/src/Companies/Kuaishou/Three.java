package Companies.Kuaishou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            String tmp = s.nextLine();
            String[] str = tmp.split(" ");
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> list1 = new ArrayList<>();

            String[] ss = str[0].split("\\.");
            for (int k = 0; k < ss.length; k++) {
                list.add(ss[k]);
            }
            while (list.get(list.size() - 1) == "0") {
                list.remove(list.size() - 1);
            }

            String[] ss1 = str[1].split("\\.");
            for (int k = 0; k < ss1.length; k++) {
                list1.add(ss1[k]);
            }
            while (list1.get(list1.size() - 1) == "0") {
                list1.remove(list1.size() - 1);
            }

            for (int j = 0; j < list.size() && j < list1.size(); j++) {
                if (list.get(j).compareTo(list1.get(j)) >= 0) {
                    System.out.println(false);
                    break;
                }
            }
            System.out.println(true);


        }
    }
}
