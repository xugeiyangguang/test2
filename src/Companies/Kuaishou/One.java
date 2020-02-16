package Companies.Kuaishou;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = s.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String line = lines[i];
            String one = line.split(" ")[0];
            String two = line.split(" ")[1];
            String[] str1 = one.split("\\.");
            String[] str2 = two.split("\\.");

            int cur = 0;
            while (cur < str1.length && cur < str2.length) {
                //小于的话，直接可以升级
                if (Integer.valueOf(str1[cur]) < Integer.valueOf(str2[cur])) {
                    System.out.println("true");
                    break;
                    //相等继续比较
                } else if (str1[cur].compareTo(str2[cur]) == 0) {
                    cur++;
                    continue;
                } else {
                    System.out.println("false");
                    break;
                }
            }
            if (cur == str2.length) {
                System.out.println("false");
                continue;
            }
            if (cur == str1.length){
                System.out.println("true");
                continue;
            }

        }

    }
}
