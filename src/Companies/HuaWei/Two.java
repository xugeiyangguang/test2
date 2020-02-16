package Companies.HuaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int low = s.nextInt();
        int high = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int one = 0;
        int ten = 0;
        for (int i = low; i < high; i++) {
            if (Check(i) == true) {
                list.add(i);
                one += i % 10;
                ten += i / 10 % 10;
            }
        }
        System.out.println(Math.min(one, ten));
    }


    public static boolean Check(int m) {
        for (int i = 2; i < m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }
}
