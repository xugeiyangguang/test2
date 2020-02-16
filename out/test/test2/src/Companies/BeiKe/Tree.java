package Companies.BeiKe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Tree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
       // int[] a = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(s.nextInt());
        }
        int re = 0;
        Collections.sort(list);
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            int count = 0;
            for (; j < list.size() && list.get(j) >= list.get(i) * 0.9; j++) {
                count++;
            }
            re += count;
        }
        /*for (int i = 1; i < a.length; i++) {
            int tmp = 0;
            while (tmp < i&&a[tmp] < a[i] * 0.9) {
                tmp++;
            }
            if (tmp != i) {
                re += i - tmp;
            }
        }*/
        System.out.println(re);

    }
}
/*
*
* public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        Arrays.sort(a);
        int re = 0;
        for (int i = 1; i < a.length; i++) {
            int tmp = 0;
            while (tmp < i&&a[tmp] < a[i] * 0.9) {
                tmp++;
            }
            if (tmp != i) {
                re += i - tmp;
            }
        }
        System.out.println(re);

    }*/