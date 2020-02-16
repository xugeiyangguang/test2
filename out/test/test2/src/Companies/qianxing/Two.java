package Companies.qianxing;

import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int level = s.nextInt();
        s.nextLine();
        String[] ss = s.nextLine().split(" ");
        int[] node = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            node[i] = Integer.valueOf(ss[i]);
        }
        int a = s.nextInt();
        int b = s.nextInt();
        Arrays.sort(node);
        for (int i = 0; i < node.length; i++) {
            if (node[i] > a && node[i] < b) {
                System.out.println(node[i]);
            }
        }
        System.out.println(-1);
    }
}
