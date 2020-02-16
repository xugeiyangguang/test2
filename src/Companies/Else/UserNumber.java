package Companies.Else;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class UserNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            degree[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(scanner.nextInt());
            temp.add(scanner.nextInt());
            temp.add(scanner.nextInt());
            list.add(temp);
        }
        for (int i = 0; i < q; i++) {
            int count = 0;
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);
            for (int j = start; j <= end; j++) {
                if (degree[j] == list.get(i).get(2)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
