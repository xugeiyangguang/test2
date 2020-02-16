package Companies.Else;

import java.util.HashMap;
import java.util.Scanner;

public class Retangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x1 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = scanner.nextInt();
        }
        int[] y1 = new int[n];
        for (int i = 0; i < n; i++) {
            y1[i] = scanner.nextInt();
        }
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x2[i] = scanner.nextInt();
        }
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            y2[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashmap.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            //拿出没有重叠的矩形比较
            if (hashmap.get(i) != 1) {
                for (int j = 0; j < n; j++) {
                    if (i != j && x1[j] < x1[i] && x1[i] < x2[j]) {
                        if (y1[j] < y1[i] && y1[i] < y2[j]) {
                            hashmap.put(i, 1);
                            hashmap.put(j, 1);
                        }
                    }
                }
            }
        }
        int re = 0;
        for(int i = 0;i<n;i++){
            if(hashmap.get(i)==1){
                re++;
            }
        }
        System.out.println(re);
    }
}


