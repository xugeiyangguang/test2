package Companies.bilibili;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(",");
        int[] a = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            a[i] = Integer.valueOf(str[i]);
        }


    }
}
